/**
 * layui 中 拓展的模块
 */

layui.define(["element","jquery"],function(exports){
    var
        element = layui.element,
        $ = layui.jquery,
        //session 缓存中数据的字典
        dict = { TABS:"tabs",CURRENT_TAB:"currentTab"},
        layId,
        _session = window.sessionStorage,//会话缓存
        Tab = function(){
            this.tabConfig = {
                container : undefined,
                openTabNum : 10,  //最大可打开窗口数量，默认 10
                tabFilter : "bodyTab",  //添加窗口的filter，默认 bodyTab

            }
        };
    //静态方法
    Tab.newTab = function(){ return new Tab();}
    //参数设置
    var _prototype = {} ;

    _prototype.set = function(option) {
        var _this = this;
        $.extend(true, _this.tabConfig, option);
        return _this;
    };


    /**
     * 菜单点击后触发
     * 如果菜单已经在列表，则focus到对应标签，显示对应页面，
     * 如果菜单未在列表，则添加对应tab,显示对应列
     * @param $item
     */
    var tabIdIndex = 0;
    _prototype.tabAdd = function($item){
        var
            tabs = [],
            _this = this,
            _config = _this.tabConfig,
            tabTitle = ""
        ;

        if(_session.getItem(dict.TABS)){
            tabs = JSON.parse(_session.getItem(dict.TABS)) || [];
        }
        //访问远程地址
        if($item.attr("target") == "_blank"){
            window.location.href = $item.attr("data-url");
            return ;
        }

        if($item.find("i.layui-icon").attr("data-icon") != undefined){
            tabTitle += '<i class="layui-icon '+ $item.find("i.layui-icon").attr("data-icon") +'"></i>';
        }

        //已打开的窗口中存在
        if( _this.hasTab($item.find("cite").text())){
            //当前窗口内容
            var curmenu = {
                "icon" : $item.find("i.layui-icon").attr("data-icon"),
                "title" : $item.find("cite").text(),
                "href" : $item.attr("data-url")
            }
            window.sessionStorage.setItem(dict.CURRENT_TAB,JSON.stringify(curmenu));  //当前的窗口
            element.tabChange(_config.tabFilter, _this.getLayId($item.find("cite").text()));
        }else{
            if($(_config.container + " li").length == _config.openTabNum){
                layer.msg('只能同时打开'+ _config.openTabNum +'个选项卡哦。不然系统会卡的！');
                return;
            }

            tabIdIndex++;
            tabTitle += '<cite>'+$item.find("cite").text()+'</cite>';
            tabTitle += '<i class="layui-icon layui-unselect layui-tab-close" data-id="'+ tabIdIndex +'">&#x1006;</i>';
            element.tabAdd(_config.tabFilter, {
                title : tabTitle,
                content :"<iframe src='"+ $item.attr("data-url") +"' data-id='"+ tabIdIndex +"'></frame>",
                id : new Date().getTime()
            })
            //当前窗口内容
            var curmenu = {
                "icon" : $item.find("i.layui-icon").attr("data-icon"),
                "title" : $item.find("cite").text(),
                "href" : $item.attr("data-url"),
                "layId" : new Date().getTime()
            }

            tabs.push(curmenu);
            _session.setItem(dict.TABS,JSON.stringify(tabs)); //打开的窗口
            _session.setItem(dict.CURRENT_TAB,JSON.stringify(curmenu));  //当前的窗口
            element.tabChange(_config.tabFilter, _this.getLayId($item.find("cite").text()));

        }
    }

    //通过title获取lay-id
    _prototype.getLayId = function(title){
        var
            _this = this,
            _config = _this.tabConfig,
            layId
        ;
        $(_config.container + " li").each(function(){
            if($(this).find("cite").text() == title){
                layId =  $(this).attr("lay-id");
            }
        })

        return layId;
    }

    /**
     * 通过title判断tab是否存在
     * @param title
     * @returns {boolean}
     */
    _prototype.hasTab = function(title){
        var
            _this = this,
            _config = _this.tabConfig,
            ifHas = false
        ;
        $(_config.container + " li").each(function(){
            if($(this).find("cite").text() == title){
                ifHas =  true ;
            }
        })
        return ifHas ;
    }


    Tab.prototype = _prototype ;
    //发布模块
    exports("tab",function(option){
        return Tab.newTab().set(option);
    });
})