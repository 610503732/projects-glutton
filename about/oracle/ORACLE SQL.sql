/*************************数据控制语言DCL*********************************/
--是用来设置或者更改数据库用户或角色权限的语句，这些语句包括GRANT、DENY、REVOKE等语句

/*************************数据定义语言DDL*********************************/
--是SQL语言集中负责数据结构定义与数据库对象定义的语言，由CREATE、ALTER与DROP三个语法所组成

---CREATE	(举凡数据库、数据表、序列、数据库索引、预存程序、用户函数、触发程序)
--1、数据库

--2、数据表
	--语法
	create table tb_name (...);
	
	--根据已有表创建新表
	create table tb_name as 
	select * from src_tb_name ;
	
	--注释表
	comment on table tb_name is '注释表';
	--注释列
	comment on column tb_name.col is '注释列';
--3、序列
	--语法
	create sequence seq_name
	start with 1	--序列开始位置
	increment by 1	--序列步长
	--使用
	seq_name.nextval --获取下一个序列号
	seq_name.currval --获取当前序列号
	
	
	
---ALTER
	--重命名表
	alter table old_tb_name rename to new_tb_name ;
	--重命名列
	alter table tb_name rename old_col_name to new_col_name;
	--增加列
	alter table tb_name add (...,..);
	--删除列
	alter table tb_name drop (...,..);
	--修改列
	alter table tb_name modify (...,..);
	
---DROP
	--删除表
	drop table tb_name ;
	
/*************************数据查询语言DQL*********************************/
---1、简单查询
--as 别名
	select col as oth_name from tb_name ;
	select col oth_name from tb_name ;
--group by 分组
	select col1 from tb_name group by col1 [having ... ] ;
--order by 排序
	select * from tb_name order by col [aec] ;-- 小->大 （默认）
	select * from tb_name order by col desc ;-- 大->小
	select * from tb_name order by col1 desc,col2 desc,col3 ;--多字段排序
--distinct 去除重复行
	select distinct * from tb_name ;
	
---2、条件查询
--** =,<,>,<=,>=,<>
--** all,any,between...and...
--like 模糊匹配
	select * from tb_name where col like '_%aa%_';-- '-' 表示一个任意字符 ，'%' 表示任意多个字符 
	select * from tb_name where col like '_aa\_' escape '\';-- 表示'\'为转义字符，用于匹配'_'和'%'
--NULL 空值匹配
	select * from tb_name where col is null ;--为空
	select * from tb_name where col is not null ;--不为空
--IN 
	select * from tb_name where col in (...,...,...) ;--在结果集中
	select * from tb_name where col not in (...,...,...) ;--不在结果集中
	
--EXISTS
	select * from tb_name where col exists (.....子查询) ;--存在于子查询结果集
	select * from tb_name where col not exists (.....子查询) ;--不存在

---3、高级查询	
--分页
	select * 
	from (
			select a.*,rownum num 
			from (
				select * from tb_name 
				) a
		) b	
	where num>=3 and num<=5 ;
--decode 自定义分类、自定义排序
	select decdoe(col,val,'a'[,val,'b'[.....]],'z') from tb_name group by decode(...同上) ;
--rank

--递归查询
	--获取证投部所有团队
	select id,name
  	from sys_group
  	start with id='49010'--证券投资部
	connect by prior id=pid ;
	
/*************************数据操纵语言DML*********************************/
--INSERT（插入）、UPDATE（修改）、DELETE/TRUNCATE（删除）语句

---INSERT
	--语法
	insert into tb_name (...) values (...) ;
	--根据查询的结果集插入
	insert into tb_name select * from src_tb_name ;
	
---UPDATE
	--语法
	update tb_name t set col1=val1,... where ... ;
	update tb_name t set (col1,col2..)=(...结果集) where ... ;
	
---DELETE/TRUNCATE
	--删除记录
	delete [from] tb_name [where .... ];
	--清空表，立即生效，无法回滚
	truncate table tb_name ;

/*************************字段操作*********************************/
--------------------------日期操作
--date	精确到秒
--timestamp 可以精确熬ns（纳秒）
--sysdate oracle内部函数，返回当前系统时间（s） 	2016/12/27 17:40:47
	select sysdate from dual ;
--systimestamp 内部函数，返回当前日期（ms）		27-12月-16 05.40.47.143234 下午 +08:00
	select systimestamp from dual ;
--to_date(char[,fmt])
	select to_date('20161010','yyyymmdd') from tb_name ;
--to_char(date[,fmt])
	select to_char(create_ts,'yyyymmdd') from tb_name ;
--last_day(date)	返回当月最后一天
	select last_day(sysdate) from dual ;
--add_months(date,i)	date加上i个月后的日期值
	select add_months(sysdate,2) from dual ;
	select add_months(sysdate,-1) from dual ;
--months_between(date1,date2) 返回两个日期间隔月数（前者大于后者才能得到正值）
	select months_between(to_date('20160203','yyyymmdd'),to_date('20160101','yyyymmdd')) from dual ;--1.06451612903226
--next_day(date,char) 返回date日期的下一个周几（i 1-7  日-六）	
	select next_day(sysdate,2) from dual ;
--extract(date from datetime) 从datetime中提取参数date{ YEAR | MONTH | DAY | HOUR | MINUTE | SECOND } 指定的数据
	select extract( day from to_date( '20161205','yyyymmdd') ) from dual ;--5
	select extract( month from to_date( '20161205','yyyymmdd') ) from dual ;--12
	select extract( year from to_date( '20161205','yyyymmdd') ) from dual ;--2016
--least(...,...) 比较函数，返回最小
	select least(1,2) from dual ;--1
	select least(to_date('20161205','yyyymmdd'),to_date('20161204','yyyymmdd')) from dual ;--2016/12/4
--greatest(...,...)	比较函数，返回最大
	select greatest(1,2) from dual ;--2
	select greatest(to_date('20161205','yyyymmdd'),to_date('20161204','yyyymmdd')) from dual ;--2016/12/5
	
--------------------------数值操作
--number(p) 整数
--number(p,s) 浮点数
--round(n[,m]) 四舍五入
	select round(652.3435,-1) from dual ;--650
	select round(652.3435) from dual ;--652
	select round(652.3435,1) from dual ;--652.3
	select round(652.3435,2) from dual ;--652.35	
--trunc(n[,m]) 截取小数点后m位，有方向
	select trunc(652.3455,-1) from dual ;--650
	select trunc(652.3455) from dual ;--652
	select trunc(652.3455,1) from dual ;--652.3
	select trunc(652.3455,2) from dual ;--652.34
--mod(m,n) 取余函数，返回m/n的余数，n为0则返回m
	select mod(5.9,2) from dual ;--1.9
  	select mod(5.9,0) from dual ;--5.9
--ceil(n) 向上取整
	select ceil(55.11) from dual ;--56
   	select ceil(55.99) from dual ;--56
--floor(n) 向下取整
	select floor(55.11) from dual ;--55
   	select floor(55.99) from dual ;--55
--nvl(col,char) 将col中null替换为char
--nvl2(col,c1,c2) 将col中非null替换为c1，null替换为c2

--------------------------字符串操作   	
--char
--varchar
--varchar2
--concat || 字符串连接
	select concat(col,char) from tb_name ;
	select 'a'||':'||'b' from dual ;--a:b
--length(char)
	select length('') from dual ;--0
	select length('5555') from dual ;--4
--upper(char) --转换大写
--lower(char) --转换小写
--initcap(char) --单词首字母大写
--trim(c2 from c1) 从c1前后截去c2
	select trim('5' from '55454545455') from dual ;--4545454
--ltrim(c1[,c2]) 从c1左边截去空格或c2
--rtrim(c1[,c2]) 从c1右边截去空格或c2
--lpad(c1,n,cc2) 对c1左补位n个c2
--rpad(c1,n,cc2) 对c1右补位n个c2
--substr(char,m[,n]) / regexp_substr(...)
	--m 截取其实位置
	--n 截取长度
--instr(c1,c2[,n[,m]])
	--n 其实位置
	--m 出现次数	

--------------------------组函数
--avg(number)	平均值
--sum(number) 	求和
--count(*)  	统计，计数
--max(*)		最大值
--min(*)		最小值

--------------------------
	
	
	