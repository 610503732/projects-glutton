/**
 * layui 中 拓展的模块
 */

layui.define(["element","tab","jquery"],function(exports){
    var element = layui.element,
        $ = layui.jquery,
        //session 缓存中数据的字典
        dict = { MENU:"menu"},
        tab = layui.tab,
        _session = window.sessionStorage,//会话缓存
        Nav = function(){
            this.navConfig = {
                container : undefined,
                url:undefined,
                tab:undefined
            }
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

    /**
     * 设置完配置后的初始化行为
     * @returns {_prototype}
     */
    _prototype.init = function(){
        var
            _this = this,
            _config = _this.navConfig;

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
            $container = $(_config.container) ;

        $.get(_config.url,function(data){
            //显示左侧菜单
            if($container.html() == ''){

            }
            $container.html(_this.parse2html(data));
            element.init();  //初始化页面元素
            // $(window).resize(function(){
            //     $container.height($(window).height()-245);
            // })
        })
    };

    /**
     * 传入 json data
     * 返回导航菜单的 html
     *
     *
     * @param $json
     * @returns {string}
     */
    _prototype.parse2html = function($json){

        var data = $json ,
            ulHtml = '<ul class="layui-nav layui-nav-tree">';

        for(var i=0;i<data.length;i++){
            if(data[i].spread){
                ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
            }else{
                ulHtml += '<li class="layui-nav-item">';
            }

            if(data[i].children && data[i].children.length > 0){
                ulHtml += '<a href="javascript:;">';
                if(data[i].icon) ulHtml += '<i class="'+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                ulHtml += '<cite>'+data[i].title+'</cite>';
                ulHtml += '<span class="layui-nav-more"></span>';
                ulHtml += '</a>';
                ulHtml += '<dl class="layui-nav-child">';

                for(var j=0;j<data[i].children.length;j++){
                    if(data[i].children[j].target == "_blank"){
                        ulHtml += '<dd><a href="javascript:;" data-id="'+ data[i].children[j].id +'" data-url="'+data[i].children[j].url+'" target="'+data[i].children[j].target+'">';
                    }else{
                        ulHtml += '<dd><a href="javascript:;" data-id="'+ data[i].children[j].id +'" data-url="'+data[i].children[j].url+'">';
                    }
                    if(data[i].children[j].icon ) ulHtml += '<i class="'+data[i].children[j].icon+'" data-icon="'+data[i].children[j].icon+'"></i>';
                    ulHtml += '<cite>'+data[i].children[j].title+'</cite></a></dd>';
                }
                ulHtml += "</dl>";

            }else{
                if(data[i].target == "_blank"){
                    ulHtml += '<a href="javascript:;" data-id="'+ data[i].id +'" data-url="'+data[i].url+'" target="'+data[i].target+'">';
                }else{
                    ulHtml += '<a href="javascript:;" data-id="'+ data[i].id +'" data-url="'+data[i].url+'">';
                }
                if(data[i].icon) ulHtml += '<i class="'+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                ulHtml += '<cite>'+data[i].title+'</cite></a>';
            }
            ulHtml += '</li>';

        }
        ulHtml += '</ul>';

        return ulHtml ;

    }



    Nav.prototype = _prototype ;
    //发布模块
    exports("nav",function(option){
        return Nav.newNav().set(option).init();
    });
})