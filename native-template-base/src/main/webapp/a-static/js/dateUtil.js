/**
 * 功能 ： 格式化日期 使用方法 ： [Date型变量].format('yyyy/MM/dd hh:mm:ss W'); 特别说明 ：
 * 格式方式与Java中日期型对象的格式方式一致， 其中，y+表示年份，M+表示月份，d+表示日期， h+表示小时，m+表示分钟，s+表示秒，
 * W表示中文星期（星期一），w表示英文星期（Monday）。
 * 
 * @param String :
 *            fmt 格式，使用以上字符串组成，例： yyyy年MM月dd日 W hh:mm:ss
 * @return String 格式化后的日期字符串
 */
Date.prototype.format = function(fmt) {
	var o = {
		'M+' : this.getMonth() + 1,
		'd+' : this.getDate(),
		'h+' : this.getHours(),
		'm+' : this.getMinutes(),
		's+' : this.getSeconds(),
		'q+' : Math.floor((this.getMonth() + 3) / 3),
		'W' : "星期" + '日一二三四五六'.substr(this.getDay(), 1),
		'w' : [ 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday',
				'Friday', 'Saturday' ][this.getDay()]
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp('(' + k + ')').test(fmt)) {
			fmt = fmt.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ('00' + o[k]).substr(('' + o[k]).length));
		}
	}
	return fmt;
};

/**
 *js中更改日期
 * y年， m月， d日， h小时， n分钟，s秒
 */
Date.prototype.add = function (part, value) {
	value *= 1;
	if (isNaN(value)) {
		value = 0;
	}
	switch (part) {
		case "y":
			this.setFullYear(this.getFullYear() + value);
			break;
		case "m":
			this.setMonth(this.getMonth() + value);
			break;
		case "d":
			this.setDate(this.getDate() + value);
			break;
		case "h":
			this.setHours(this.getHours() + value);
			break;
		case "n":
			this.setMinutes(this.getMinutes() + value);
			break;
		case "s":
			this.setSeconds(this.getSeconds() + value);
			break;
		default:

	}
}

/**
 * 
 * @param date
 *            当前日期
 * @param days
 *            相差天数
 * @returns {Date}
 */
$.extend({
	addDays : function(date, days) {
		var d = new Date(date);
		d = d.valueOf();
		d = d + days * 24 * 60 * 60 * 1000;
		d = new Date(d);
		return d;
	}
});

$.extend({
	createDomain : function() {
		var a = arguments, o = null, i, j, d;
		for (i = 0; i < a.length; i = i + 1) {
			d = a[i].split(".");
			o = window;
			for (j = 0; j < d.length; j = j + 1) {
				o[d[j]] = o[d[j]] || {};
				o = o[d[j]]
			}
		}
		return o;
	}
});
