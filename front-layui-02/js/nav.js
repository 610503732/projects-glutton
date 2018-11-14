/**
 * layui 中 拓展的模块
 */

layui.define(["element","tab","jquery"],function(exports){
    var element = layui.element,
        $ = layui.jquery,
        //session 缓存中数据的字典
        dict = { MENU:"menu"},
        layId,
        _session = window.sessionStorage,//会话缓存
        Nav = function(){
            this.tab = undefined;
            this.navConfig = {
                container : undefined,
                url:undefined
            }
        },
        MenuItem = function(){
            this.title = undefined;
            this.icon = undefined;
            this.href = undefined;
            this.spread = undefined;
        }

    ;
    //静态方法
    Nav.newNav = function(){ return new Nav();}
    //参数设置

    var _prototype = {} ;
    _prototype.set = function(option) {
        var _this = this;
        $.extend(true, _this.navConfig, option);
        return _this;
    };

    _prototype.setTab = function (_tab){
        this.tab = _tab ;
        //绑定nav 和 tab
        this.bindNavTab();
        return this ;
    }

    /**
     * 绑定导航和标签页
     */
    _prototype.bindNavTab = function(){
        var
            _this = this,
            _config = _this.navConfig;

        $(_config.container).on("click",".layui-nav .layui-nav-item a",function(){
            //如果不存在子级
            if($(this).siblings().length == 0){
                _this.tab.tabAdd($(this));
                $('body').removeClass('site-mobile');  //移动端点击菜单关闭菜单层
            }
            $(this).parent("li").siblings().removeClass("layui-nav-itemed");
        })
    }

    /**
     * 设置完配置后的初始化行为
     * @returns {_prototype}
     */
    _prototype.init = function(){
        var _this = this ;
        _this.render();
        return _this ;
    };

    /**
     * 组件渲染
     */
    _prototype.render = function(){

        var
            _this = this,
            _config = _this.navConfig,
            $navCntainer = $(_config.container),
            url = _config.url;

        var menu = _session.getItem(dict.MENU) ;
        //判断缓存是否有菜单数据
        if(!menu){
            //如果缓存中没有数据，则请求获取，直接进行渲染操作
            $.get(url,function(data){
                _session.setItem(dict.MENU,JSON.stringify(data));

                $navCntainer.html(_this.parseJsonToHtml(data));
                element.init();  //初始化页面元素
            })
        }else{
            $navCntainer.html(_this.parseJsonToHtml(menu));
            element.init();  //初始化页面元素
        }
    };

    /**
     *  将菜单 json 解析成 html
     * @param json
     * @returns {string}
     */
    _prototype.parseJsonToHtml = function(strData){

        var data;
        if(typeof(strData) == "string"){
            var data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
        }else{
            data = strData;
        }
        var ulHtml = '<ul class="layui-nav layui-nav-tree">';
        for(var i=0;i<data.length;i++){
            if(data[i].spread){
                ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
            }else{
                ulHtml += '<li class="layui-nav-item">';
            }
            if(data[i].children != undefined && data[i].children.length > 0){
                ulHtml += '<a href="javascript:;">';
                if(data[i].icon != undefined && data[i].icon != ''){
                    if(data[i].icon.indexOf("icon-") != -1){
                        ulHtml += '<i class="iconfont '+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                    }else{
                        ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';
                    }
                }
                ulHtml += '<cite>'+data[i].title+'</cite>';
                ulHtml += '<span class="layui-nav-more"></span>';
                ulHtml += '</a>';
                ulHtml += '<dl class="layui-nav-child">';
                for(var j=0;j<data[i].children.length;j++){
                    if(data[i].children[j].target == "_blank"){
                        ulHtml += '<dd><a href="javascript:;" data-url="'+data[i].children[j].href+'" target="'+data[i].children[j].target+'">';
                    }else{
                        ulHtml += '<dd><a href="javascript:;" data-url="'+data[i].children[j].href+'">';
                    }
                    if(data[i].children[j].icon != undefined && data[i].children[j].icon != ''){
                        if(data[i].children[j].icon.indexOf("icon-") != -1){
                            ulHtml += '<i class="iconfont '+data[i].children[j].icon+'" data-icon="'+data[i].children[j].icon+'"></i>';
                        }else{
                            ulHtml += '<i class="layui-icon" data-icon="'+data[i].children[j].icon+'">'+data[i].children[j].icon+'</i>';
                        }
                    }
                    ulHtml += '<cite>'+data[i].children[j].title+'</cite></a></dd>';
                }
                ulHtml += "</dl>";
            }else{
                if(data[i].target == "_blank"){
                    ulHtml += '<a href="javascript:;" data-url="'+data[i].href+'" target="'+data[i].target+'">';
                }else{
                    ulHtml += '<a href="javascript:;" data-url="'+data[i].href+'">';
                }
                if(data[i].icon != undefined && data[i].icon != ''){
                    if(data[i].icon.indexOf("icon-") != -1){
                        ulHtml += '<i class="iconfont '+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                    }else{
                        ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';
                    }
                }
                ulHtml += '<cite>'+data[i].title+'</cite></a>';
            }
            ulHtml += '</li>';
        }
        ulHtml += '</ul>';

        return ulHtml;

    }



    Nav.prototype = _prototype ;
    //发布模块
    exports("nav",function(option){
        return Nav.newNav().set(option).init();
    });
})