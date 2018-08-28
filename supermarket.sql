/*创建数据库*/
create database superMarketManager;

/*创建表*/

/*创建表*/
create table UserBean(
   u_id int auto_increment primary key,
   u_name varchar(20) not null,
   u_password varchar(20) not null,
   u_gender varchar(10) not null,
   u_age int not null,
   u_phone varchar(20) not null,
   u_address varchar(50) not null,
   u_auth varchar(20) not null
)engine=InnoDB default charset utf8;

insert into UserBean values(1,"mary","123456","男",21,"1234567","南京网博","管理员");

/*编号,姓名,密码,性别,年龄,电话号码,地址,权限*/
/*创建账单表 */
create table AccountBean(
   a_id int auto_increment primary key,
   a_name varchar(20) not null,
   a_nums int not null,
   a_amount varchar(20) not null,
   a_unit varchar(20) not null,
   
   a_ispayed int not null,
   s_id int not null,
   s_name varchar(20) not null,
   a_Info varchar(30) not null,
   a_Date date not null
)engine=InnoDB default charset utf8;
/*"账单编号","商品名称","商品数量","交易金额","是否付款","供应商名称","商品描述","账单时间"*/
insert into AccountBean values(1,"小米9",3,"2000","元",1,1,"小米科技","为发烧而生","2018-08-21");
/*创建供应商信息表*/
create table SupplierBean(
  s_id int auto_increment primary key,
  s_name varchar(20) not null,
  s_info varchar(30) not null,
  s_linkman varchar(20) not null,
  s_phone varchar(20) not null,
  s_address varchar(30) not null,
  s_faxes varchar(20) not null

)engine=InnoDB default charset utf8;

select 

/*供应商编号,供应商名称,供应商描述,供应商联系人,供应商电话,供应商地址,供应商传真*/

insert into SupplierBean values(1,"小米科技","为发烧而生","雷军","123456","北京","123456");
/*�������*/
/*����UserBean��*/
insert into UserBean values(?,?,?,?,?,?,?,?);
/*����AccountBean��*/
insert into AccountBean values(?,?,?,?,?,?,?,?,?,?);
/*����Supplier��*/
insert into SupplierBean values(?,?,?,?,?,?,?);

/*��ѯ���*/
/*��ѯUserBean��*/
select * from UserBean;
/*��ѯAccountBean��*/
select * from AccountBean;
/*��ѯSupplier��*/
select * from SupplierBean;

/*������*/
update  UserBean set    ;


/*ɾ�����*/
alter table UserBean drop   where   ;



