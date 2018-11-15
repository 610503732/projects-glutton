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
     * 初始化
     */
    _prototype.init = function(){
        var
            _this = this,
            _config = _this.tabConfig
        ;

        //删除tab
        $(_config.container).on("click"," li i.layui-tab-close",function(){
            element.tabDelete(_config.tabFilter,$(this).parent("li").attr("lay-id")).init();
        })

        return _this ;
    }


    /**
     * 菜单点击后触发
     * 展示对应菜单页和内容
     * @param $item
     */
    _prototype.show = function(_menu){
        var
            _this = this,
            _config = _this.tabConfig
        ;

        if(!_this.hasTab(_menu.id)){
            _this.add(_menu);
        }
        //这里的 lay-id 都为菜单项id
        element.tabChange(_config.tabFilter, _menu.id);

    }

    /**
     * 新增菜单选项卡
     * @param _menu
     */
    _prototype.add = function(_menu){

        var
            _this = this,
            _config = _this.tabConfig,
            _param = {
                id:_menu.id,
                title:"",
                content:""
            };

        //title 拼装
        if(_param.icon) _param.title += '<i class="layui-icon '+ _param.icon +'"></i>' ;
        _param.title += '<cite>'+ _menu.title +'</cite>';
        _param.title += '<i class="layui-icon layui-tab-close layui-unselect" data-id="'+ _menu.id +'">&#x1006;</i>';

        //content 拼装
        _param.content+= '<iframe src="'+ _menu.url +'" data-id="'+ _menu.id +'" frameborder="0" ></frame>';
        //组件添加
        element.tabAdd(_config.tabFilter,_param );

    }

    /**
     * 删除全部
     */
    _prototype.deleteAll = function(){
        var
            _this = this,
            _config = _this.tabConfig;

        $(_config.container + " li i.layui-tab-close").click() ;
    }

    _prototype.deleteOth = function(){
        var
            _this = this,
            _config = _this.tabConfig;

        $(_config.container + " li:not(.layui-this) i.layui-tab-close").click() ;
    }

    /**
     * 通过 layid 判断是否已经打开对应的标签
     * @param layId
     * @returns {boolean}
     */
    _prototype.hasTab = function(layId){
        var
            _this = this,
            _config = _this.tabConfig;

        if($( _config.container + " li[lay-id='"+ layId +"']").length > 0) return true ;
        return false ;
    }







    Tab.prototype = _prototype ;
    //发布模块
    exports("tab",function(option){
        return Tab.newTab().set(option).init();
    });
})