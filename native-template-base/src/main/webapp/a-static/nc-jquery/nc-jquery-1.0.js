/**
 * 封装js
 */
;
(function() {

	var JShake = window.JShake = window.$ = function(selector, context) {// 构造函数
		return new JShake.fn.init(selector, context);
	};

	JShake.fn = JShake.prototype = {// 实例对象
		init : function(selector, context) {
			
			//function
			if (typeof selector === "function") {
				JShake.fn.ready(selector);
				return this ;
			}

			// $(""), $(nul), or $(undefined)
			if (!selector) {
				return this;
			}

			// $(DOMElement)
			if (selector.nodeType) {
				this.context = this[0] = selector;
				this.length = 1;
				return this;
			}
			// $(string)
			if (typeof selector === "string") {
				this.selector = selector;
				this.context = document;

				// $(#id)
				if (/^#/.test(selector)) {
					selector = document.getElementById(selector.substr(1));
					// $(.class)
				} else if (/^\./.test(selector)) {
					selector = document.getElementsByClassName(selector
							.substr(1));
					// $(TAG)
				} else {
					selector = document.getElementsByTagName(selector);
				}

				return JShake.merge(this, selector);
			}

		},
		selector : "",
		jshake : "1.0",
		length : 0,
		// 分割函数对象为数组
		splice : [].splice
	};

	// 构成链式调用
	JShake.fn.init.prototype = JShake.fn;
	// 继承
	JShake.extend = JShake.fn.extend = function(options) {

		// 合并
		for (name in options) {
			this[name] = options[name];
		}

		// 返回合并后的实例
		return this;

	};
	// 继承方法-实例
	/******************属性********************/
	//HTML代码/文本/值
	JShake.fn.extend({
		html : function(html) {
			var str = "";
			this.each(function() {
				if (html) {
					this.innerHTML = html;
				} else {
					str = str + this.innerHTML;
				}
			});
			return html ? this : str;
		},
		text : function(text) {// 获取文本
			var str = "";
			this.each(function() {
				if (text) {
					this.innerText = text;
				} else {
					str = str + this.innerText;
				}
			});
			return text ? this : str;
		},
		val : function(val) {
			var str = "";
			this.each(function() {
				if (val) {
					this.value = val;
				} else {
					str = str + this.value;
				}
			});
			return val ? this : str;
		}
	});
	/******************文档处理********************/
	//内部插入
	JShake.fn.extend({
		/**
		 * 向每个匹配的元素内部追加内容
		 */
		append:function(html,index){
			var _this=this;
			_this.each(function(i){
				if(index && index != i){ return; }
				$(this).html($(this).html() + html);
			});
		},
		/**
		 * 向每个匹配的元素内部前置内容
		 */
		prepend:function(html,index){
			var _this=this;
			_this.each(function(i){
				if(index && index != i){ return; }
				$(this).html( html + $(this).html());
			});
		}
	});


	/******************筛选********************/
	// 查找
	JShake.fn.extend({
		// 遍历
		each : function(callBack) {
			JShake.each(this,callBack) ;
		},
		// 查找
		find : function(selector) {
			
		}
	});
	
	
	
	/******************事件********************/
	//页面载入
	JShake.fn.extend({
		ready:function(callBack){
			window.onload = callBack.call(this[i]);//页面加载后执行
		}
	});
	//事件处理
	JShake.fn.extend({
		//事件行为，绑定事件或触发事件
		action:function(type,callBack){
			if(callBack && typeof callBack === "function"){
				this.bind(type,callBack);
			}else{
				this.trigger(type);
			}
		},
		//为每一个匹配的元素绑定事件
		bind:function(type,callBack){
			var _this = this ;
			_this.callBack = callBack ;
			//遍历元素数组，绑定或触发事件
			this.each(function(){
				this.addEventListener(type,_this.callBack);
			});
			
		},
		//触发匹配元素的对应事件
		trigger:function(type){
			//遍历元素数组，触发事件
			this.each(function(){
				//触发元素上绑定click事件
				this.dispatchEvent(JShake.event({action:type}));
			});
		}
	});
	
	var liveArr ;//记录绑定事件
	
	//事件委派
	JShake.fn.extend({
		/**
		 * 绑定事件，后来加入的元素也生效
		 */
		live:function(type,callBack){
			var selector = this.selector,obj=new Object() ;
			
			liveArr = liveArr?liveArr:new Array();
			obj.selector = selector;
			obj.callBack = callBack ;
			
			liveArr.push(obj);
			
			document.onclick = function(event){
				
				var e = event ? event : window.event;
				//解决浏览器兼容的问题，e.srcElement IE,e.target FF  
				var target = e.srcElement || e.target;                    
				if(e.type == type ){
					for(j in liveArr ){
						var _obj = $(liveArr[j].selector) ;
						for(var i=0;i<_obj.length;i++){
							if(target.isEqualNode(_obj[i])){
								liveArr[j].callBack.call(_obj[i]);    //如果元素类型和事件类型同时匹配,则执行函数  
							}
						}
					}
					
				}  
			};
		}
	});
	
	//事件
	JShake.extend({
		event:function(param){
			param = param||{type:"HTMLEvents",action:"click",bubble:false,celable:true} ;
			param.type = param.type?param.type:"HTMLEvents" ;//HTMLEvents MouseEvents UIEvents
			param.action = param.action?param.action:"click";
			param.bubble = param.bubble?param.bubble:true ;//事件是否起泡。
			param.celable = param.celable?param.celable:true ;//是否可以用 preventDefault() 方法取消事件。
			
			var event = document.createEvent(param.type);
			event.initEvent(param.action, param.bubble, param.celable);
			
			return event ;
		}
		
	});
	JShake.fn.extend({
		click:function(callBack){
			
			this.action("click",callBack);
		}
	});
	
	/******************工具********************/
	//数组和对象操作
	JShake.extend({//对象操作
		// 对象[date]
		date : {
			/**
			 * 将日期格式化成指定格式的字符串
			 * @param date 要格式化的日期，不传时默认当前时间，也可以是一个时间戳
			 * @param fmt 目标字符串格式，支持的字符有：y,M,d,q,w,H,h,m,S，默认：yyyy-MM-dd HH:mm:ss
			 * @returns 返回格式化后的日期字符串
			 */
			format:function(date, fmt){
			    date = date == undefined ? new Date() : date;
			    date = typeof date == 'number' ? new Date(date) : date;
			    fmt = fmt || 'yyyy-MM-dd HH:mm:ss';
			    var obj =
			    {
			        'y': date.getFullYear(), // 年份，注意必须用getFullYear
			        'M': date.getMonth() + 1, // 月份，注意是从0-11
			        'd': date.getDate(), // 日期
			        'q': Math.floor((date.getMonth() + 3) / 3), // 季度
			        'w': date.getDay(), // 星期，注意是0-6
			        'H': date.getHours(), // 24小时制
			        'h': date.getHours() % 12 == 0 ? 12 : date.getHours() % 12, // 12小时制
			        'm': date.getMinutes(), // 分钟
			        's': date.getSeconds(), // 秒
			        'S': date.getMilliseconds() // 毫秒
			    };
			    var week = ['天', '一', '二', '三', '四', '五', '六'];
			    for(var i in obj)
			    {
			        fmt = fmt.replace(new RegExp(i+'+', 'g'), function(m)
			        {
			            var val = obj[i] + '';
			            if(i == 'w') return (m.length > 2 ? '星期' : '周') + week[val];
			            for(var j = 0, len = val.length; j < m.length - len; j++) val = '0' + val;
			            return m.length == 1 ? val : val.substring(val.length - m.length);
			        });
			    }
			    return fmt;
			},
	        /**
	         * 将一个日期格式化成友好格式，比如，1分钟以内的返回“刚刚”，
	         * 当天的返回时分，当年的返回月日，否则，返回年月日
	         * @param {Object} date
	         */
	        formatDateToFriendly: function(date) {
	            date = date || new Date();
	            date = typeof date === 'number' ? new Date(date) : date;
	            var now = new Date();
	            if((now.getTime() - date.getTime()) < 60*1000) return '刚刚'; // 1分钟以内视作“刚刚”
	            var temp = this.format(date, 'yyyy年M月d');
	            if(temp == this.format(now, 'yyyy年M月d')) return this.format(date, 'HH:mm');
	            if(date.getFullYear() == now.getFullYear()) return this.format(date, 'M月d日');
	            return temp;
	        },
	        /**
	         * 将一段时长转换成友好格式，如：
	         * 147->“2分27秒”
	         * 1581->“26分21秒”
	         * 15818->“4小时24分”
	         * @param {Object} second
	         */
	        formatDurationToFriendly: function(second) {
	            if(second < 60) return second + '秒';
	            else if(second < 60*60) return (second-second%60)/60+'分'+second%60+'秒';
	            else if(second < 60*60*24) return (second-second%3600)/60/60+'小时'+Math.round(second%3600/60)+'分';
	            return (second/60/60/24).toFixed(1)+'天';
	        },
	        /** 
	         * 将时间转换成MM:SS形式 
	         */
	        formatTimeToFriendly: function(second) {
	            var m = Math.floor(second / 60);
	            m = m < 10 ? ( '0' + m ) : m;
	            var s = second % 60;
	            s = s < 10 ? ( '0' + s ) : s;
	            return m + ':' + s;
	        },
			/**
			 * 将字符串解析成日期
			 * 
			 * @param str
			 *            输入的日期字符串，如'2014-09-13'
			 * @param fmt
			 *            字符串格式，默认'yyyy-MM-dd'，支持如下：y、M、d、H、m、s、S，不支持w和q
			 * @returns 解析后的Date类型日期
			 */
			parse : function(str, fmt) {
//				if(str instanceof Date)return str ;//参数错误，本身为日期
				fmt = fmt || 'yyyy-MM-dd';
				var obj = {
					y : 0,
					M : 1,
					d : 0,
					H : 0,
					h : 0,
					m : 0,
					s : 0,
					S : 0
				};
				fmt.replace(/([^yMdHmsS]*?)(([yMdHmsS])\3*)([^yMdHmsS]*?)/g,
						function(m, $1, $2, $3, $4, idx, old) {
							str = str.replace(new RegExp($1 + '(\\d{'
									+ $2.length + '})' + $4),
									function(_m, _$1) {
										obj[$3] = parseInt(_$1);
										return '';
									});
							return '';
						});
				obj.M--; // 月份是从0开始的，所以要减去1
				var date = new Date(obj.y, obj.M, obj.d, obj.H, obj.m, obj.s);
				if (obj.S !== 0)
					date.setMilliseconds(obj.S); // 如果设置了毫秒
				return date;
			},
			/**
	         * 计算2日期之间的天数，用的是比较毫秒数的方法
	         * 传进来的日期要么是Date类型，要么是给定格式fmt的字符串日期，默认 yyyy-MM-dd
	         * @param date1 日期一
	         * @param date2 日期二
	         * @param fmt 日期格式
	         */
	        countDays: function(date1, date2,fmt) {
	            fmt = fmt||'yyyy-MM-dd';
	            date1 =  typeof date1 === 'string'?this.parse(date1, fmt):date1 ;
	            date2 =  typeof date2 === 'string'?this.parse(date2, fmt):date2 ;
	            
	            // 将日期转换成字符串，转换的目的是去除“时、分、秒”
	            fmt = 'yyyy-MM-dd' ;
	            date1 = date1 instanceof Date ?this.format(date1 ,fmt):date1 ;
	            date2 = date2 instanceof Date ?this.format(date2 ,fmt):date2 ;
	            date1 =  typeof date1 === 'string'?this.parse(date1, fmt):date1 ;
	            date2 =  typeof date2 === 'string'?this.parse(date2, fmt):date2 ;
	            
	            return (date2.getTime() - date1.getTime()) / (1000*60*60*24);
	           
	        },
	        /**
	         * 计算2日期之间的月数
	         * 传进来的日期要么是Date类型，要么是给定格式fmt的字符串日期，默认 yyyy-MM-dd
	         * @param date1 日期一
	         * @param date2 日期二
	         * @param fmt 日期格式
	         */
	        countMonths:function(date1, date2,fmt){
	        	fmt = fmt||'yyyy-MM-dd';
	            date1 =  typeof date1 === 'string'?this.parse(date1, fmt):date1 ;
	            date2 =  typeof date2 === 'string'?this.parse(date2, fmt):date2 ;
	            
	            var m1 = date1.getMonth() + 1 + parseInt(date1.getFullYear()) * 12;
	            var m2 = date2.getMonth() + 1 + parseInt(date2.getFullYear()) * 12;
	            
	            return m2-m1 ;
	        },
	        /**
	         * 计算2日期之间的年数
	         * 传进来的日期要么是Date类型，要么是给定格式fmt的字符串日期，默认 yyyy-MM-dd
	         * @param date1 日期一
	         * @param date2 日期二
	         * @param fmt 日期格式
	         */
	        countYears:function(date1, date2,fmt){
	        	return parseInt(this.countMonths(date1, date2, fmt) / 12) ;
	        },
	        /**
	         * 比较2日期的大小
	         * 传进来的日期要么是Date类型，要么是给定格式fmt的字符串日期，默认 yyyy-MM-dd
	         * @param date1 日期一
	         * @param date2 日期二
	         * @param fmt 日期格式
	         * @return -1（小） date1小于date2
	         * 			0（等于）date1等于date2
	         * 			1（大） date1大于date2
	         */
	        compare:function(date1,date2,fmt){
	        	fmt = fmt||'yyyy-MM-dd';
	            date1 =  typeof date1 === 'string'?this.parse(date1, fmt):date1 ;
	            date2 =  typeof date2 === 'string'?this.parse(date2, fmt):date2 ;
	            
	            var n = date1.getTime() - date2.getTime() ;
	            
	            return n>0?1:n<0?-1:0 ;
	        },
			/**
			 * 判断两个日期是否相隔num年（默认一年）
			 */
			isDiffYear : function(start, end,num) {
				if (start && end) {
					var startTime = new Date(Date.parse(trade_date.replace(
							/-/g, "/")));
					var endTime = new Date(Date.parse(exp_date.replace(/-/g,
							"/")));
					startTime.setFullYear(startTime.getFullYear() + num ? num
							: 1);
					if (startTime < endTime) {
						return false;
					}
					return true;
				}
			},
			/**
	         * 判断某一年是否是闰年
	         * @param year 可以是一个date类型，也可以是一个int类型的年份，不传默认当前时间
	         */
	        isLeapYear: function(year) {
	            if(year === undefined) year = new Date();
	            if(year instanceof Date) year = year.getFullYear();
	            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	        },

		},
		//对象 string
		/**
		 * 去除字符串空格
		 */
		trim:function(str){
			return str.replace(/ /g,'');
		},
		//对象node
		/**
		 * 判断两个dom对象是否为同一对象
		 */
		isEqualNode:function(obj1,obj2){
			return obj1.isEqualNode(obj2)
		},
		//对象 json
		/**
		 * 解析json
		 */
		parseJSON:function(){
			
		}
	});
	
	JShake.extend({//数组操作
		/**
		 *  合并Jshake对象和dom对象
		 */
		merge : function(first, second) {

			var i = first.length, j = 0;

			if (typeof second.length === "number") {
				for (var l = second.length; j < l; j++) {
					first[i++] = second[j];
				}

			} else {
				first[i++] = second;
			}

			first.length = i;

			return first;
		},
		/**
		 * 遍历
		 */
		each:function(arr,callBack){
			var _this = arr, i = 0, length = _this.length;
			for (; i < length; i++) {
				callBack.call(_this[i], i);
			}
		},
		/**
		 * 过滤函数过滤数组元素
		 */
		grep:function(arr,fn){
			var res = new Array();
			arr = arr || new Array();

			for (i in arr) {
				if (fn(arr[i], i)) {
					res.push(arr[i]);
				}
			}
			return res;
			
		},
		/**
		 * 确定第一个参数在数组中的位置，从0开始计数(如果没有找到则返回 -1 )
		 */
		inArray:function(val,arr,fromIndex){
			arr = arr || new Array();
			fromIndex = fromIndex || 0 ;
			
			for(;fromIndex<arr.length;fromIndex++){
				if(val===arr[fromIndex]){
					return fromIndex ;
				}
			}
			return -1;
		}
	});
	
	//测试操作
	JShake.extend({
		/**
		 * 检测obj的数据类型
		 */
		type:function(obj){
			
			return obj instanceof RegExp?"regexp":
					obj instanceof Date?"date":
						obj instanceof Function?"function":
							obj instanceof Array?"array":typeof obj ;
			
		},
		/**
		 * 检测是否为数组
		 */
		isArray:function(obj){
			return obj instanceof Array ;
		},
		/**
		 * 检测是否为函数
		 */
		isFunction:function(obj){
			return obj instanceof Function ;
		},
		/**
		 * 测试是否为纯粹的对象
		 */
		isPlainObject:function(obj){
			return JShake.type(obj)==="object" ;
		}
		
	});

	/******************ajax********************/
	//ajax 请求
	JShake.extend({
		/**
		 * url:
		 * data:
		 * type:
		 * dataType:
		 * success:
		 * fail:
		 * 
		 */
		ajax : function(options) {

			options = options || {};// 短路 如果未传入参数，则为空json对象
			options.type = (options.type || "GET").toUpperCase();// 发送方式（默认GET）
			var params = options.data || "";// 目前data参数都为json串

			// 重组-暂时只支持json传参数
			params = JSON.stringify(params).replace(/:/g, '=').replace(/"/g, '')
					.replace(/,/g, '&').replace(/{/g, '').replace(/}/g, '')

			// 创建 - 非IE6 - 第一步
			if (window.XMLHttpRequest) {
				var xhr = new XMLHttpRequest();
			} else { // IE6及其以下版本浏览器
				var xhr = new ActiveXObject('Microsoft.XMLHTTP');
			}

			// 连接 和 发送 - 第二步
			if (options.type == "GET") {
				xhr.open("GET", options.url + "?" + params, true);
				xhr.send(null);
			} else if (options.type == "POST") {
				xhr.open("POST", options.url, true);
				// 设置表单提交时的内容类型
				xhr.setRequestHeader("Accept",
						"application/json, text/javascript, */*; q=0.01");
				xhr.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded");
				xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
				// JSON.stringify(params) //"name=sdfs&id=4"
				xhr.send(params);
			}

			// 接收 - 第三步
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					var status = xhr.status;
					if (status >= 200 && status < 300) {

						var response = xhr.responseText;
						if (options.dataType.toUpperCase() == "JSON") {
							response = JSON.parse(response);
						}
						options.success && options.success(response);
					} else {
						options.fail && options.fail(status);
					}
				}
			}
		}

	});

})();
