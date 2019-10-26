# transaction-springcloud
#### 1、所使用到配置
MySQL： 5.7.20-log MySQL Community Server (GPL)</br>
mysql中项目名为sectrans,下面共有四张表</br>
##### 1、admin(管理员表)
|字段名|类型|含义|
|--|--|--|
|admin_name|varchar|管理员用户名|
|admin_pwd|varchar|管理员密码|
##### 2、buy(商品交易表)
|字段名|类型|含义|
|--|--|--|
|id|int|序号|
|user_id|varchar|用户id|
|goods_id|varchar|物品id|
|trans_date|varchar|交易日期|
|state|int|订单状态|
##### 3、buy(商品表)
|字段名|类型|含义|
|--|--|--|
|goods_id|varchar|物品id|
|goods_name|varchar|物品名称|
|user_id|varchar|出售者id|
|goods_price|double|价格|
|goods_class|varchar|分类|
|goods_comment|varchar|描述|
|goods_picture|varchar|图片位置|
##### 4、user(用户表)
|字段名|类型|含义|
|--|--|--|
|user_id|varchar|用户id|
|user_name|varchar|用户昵称|
|user_pwd|varchar|用户密码|
|user_mail|double|邮箱|
|user_school|varchar|学校|
|user_major|varchar|专业|
|user_sid|varchar|学号|
