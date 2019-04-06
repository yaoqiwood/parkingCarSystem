/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/3/4 14:02:28                            */
/*==============================================================*/


drop table PARK_ADMIN cascade constraints;

drop table PARK_ADMIN_ROLE cascade constraints;

drop table PARK_ADMIN_ROLE_MENU cascade constraints;

drop table PARK_AMOUNT_LOG cascade constraints;

drop table PARK_CARNUM cascade constraints;

drop table PARK_CAR_RECORD cascade constraints;

drop table PARK_CAR_ROLE cascade constraints;

drop table PARK_CAR_SERVICE cascade constraints;

drop table PARK_CONFIGURE cascade constraints;

drop table PARK_DAILY_ACCOUNT cascade constraints;

drop table PARK_DAY_SUM cascade constraints;

drop table PARK_FEE_RULE cascade constraints;

drop table PARK_LOG cascade constraints;

drop table PARK_MACHINE_LOG cascade constraints;

drop table PARK_MENU cascade constraints;

drop table PARK_MONTH_PRODUCT cascade constraints;

drop table PARK_PLACE cascade constraints;

drop table PARK_SELF_MACHINE cascade constraints;

drop table PARK_SUBAREA cascade constraints;

drop table PARK_WHITE_LIST cascade constraints;

drop sequence SEQ_PARK_ADMIN;

drop sequence SEQ_PARK_ADMIN_ROLE;

drop sequence SEQ_PARK_ADMIN_ROLE_MENU;

drop sequence SEQ_PARK_AMOUNT_LOG;

drop sequence SEQ_PARK_CARNUM;

drop sequence SEQ_PARK_CAR_RECORD;

drop sequence SEQ_PARK_CAR_ROLE;

drop sequence SEQ_PARK_CAR_SERVICE;

drop sequence SEQ_PARK_CONFIGURE;

drop sequence SEQ_PARK_DAILY_ACCOUNT;

drop sequence SEQ_PARK_DAY_SUM;

drop sequence SEQ_PARK_FEE_RULE;

drop sequence SEQ_PARK_LOG;

drop sequence SEQ_PARK_MACHINE_LOG;

drop sequence SEQ_PARK_MENU;

drop sequence SEQ_PARK_MONTH_PRODUCT;

drop sequence SEQ_PARK_PLACE;

drop sequence SEQ_PARK_SELF_MACHINE;

drop sequence SEQ_PARK_SUBAREA;

drop sequence SEQ_PARK_WHITE_LIST;

create sequence SEQ_PARK_ADMIN
start with 100;

create sequence SEQ_PARK_ADMIN_ROLE
start with 100;

create sequence SEQ_PARK_ADMIN_ROLE_MENU
start with 100;

create sequence SEQ_PARK_AMOUNT_LOG
start with 100;

create sequence SEQ_PARK_CARNUM
start with 100;

create sequence SEQ_PARK_CAR_RECORD
start with 100;

create sequence SEQ_PARK_CAR_ROLE
start with 100;

create sequence SEQ_PARK_CAR_SERVICE
start with 100;

create sequence SEQ_PARK_CONFIGURE;

create sequence SEQ_PARK_DAILY_ACCOUNT
start with 100;

create sequence SEQ_PARK_DAY_SUM;

create sequence SEQ_PARK_FEE_RULE
start with 100;

create sequence SEQ_PARK_LOG
start with 100;

create sequence SEQ_PARK_MACHINE_LOG;

create sequence SEQ_PARK_MENU
start with 100;

create sequence SEQ_PARK_MONTH_PRODUCT
start with 100;

create sequence SEQ_PARK_PLACE
start with 100;

create sequence SEQ_PARK_SELF_MACHINE;

create sequence SEQ_PARK_SUBAREA
start with 100;

create sequence SEQ_PARK_WHITE_LIST;

/*==============================================================*/
/* Table: PARK_ADMIN                                            */
/*==============================================================*/
create table PARK_ADMIN 
(
   PA_ID                NUMBER(10)           not null,
   PA_PR_ID             NUMBER(10)           not null,
   PA_NAME              VARCHAR2(100)        not null,
   PA_PASSWORD          VARCHAR2(100)        not null,
   PA_STATE             NUMBER(1)            not null,
   PA_MEMO              VARCHAR2(100),
   PA_CREATE_TIME       DATE                 not null,
   PA_UPDATE_TIME       DATE                 not null,
   constraint PK_PARK_ADMIN primary key (PA_ID)
);

comment on column PARK_ADMIN.PA_ID is
'管理员ID';

comment on column PARK_ADMIN.PA_PR_ID is
'角色ID';

comment on column PARK_ADMIN.PA_NAME is
'管理员名称';

comment on column PARK_ADMIN.PA_PASSWORD is
'管理员密码';

comment on column PARK_ADMIN.PA_STATE is
'状态';

comment on column PARK_ADMIN.PA_MEMO is
'备注';

comment on column PARK_ADMIN.PA_CREATE_TIME is
'创建时间';

comment on column PARK_ADMIN.PA_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_ADMIN_ROLE                                       */
/*==============================================================*/
create table PARK_ADMIN_ROLE 
(
   PAR_ID               NUMBER(10)           not null,
   PAR_NAME             VARCHAR2(50)         not null,
   PAR_STATE            NUMBER(1)            not null,
   PAR_MEMO             VARCHAR2(100),
   PAR_CREATE_TIME      DATE                 not null,
   constraint PK_PARK_ADMIN_ROLE primary key (PAR_ID)
);

comment on column PARK_ADMIN_ROLE.PAR_ID is
'用户角色ID';

comment on column PARK_ADMIN_ROLE.PAR_NAME is
'用户角色名';

comment on column PARK_ADMIN_ROLE.PAR_STATE is
'状态';

comment on column PARK_ADMIN_ROLE.PAR_MEMO is
'备注';

comment on column PARK_ADMIN_ROLE.PAR_CREATE_TIME is
'创建时间';

/*==============================================================*/
/* Table: PARK_ADMIN_ROLE_MENU                                  */
/*==============================================================*/
create table PARK_ADMIN_ROLE_MENU 
(
   PARM_ID              NUMBER(10)           not null,
   PARM_PAR_ID          NUMBER(10)           not null,
   PARM_MENU_ID         NUMBER(10)           not null,
   PARM_STATE           NUMBER(10)           not null,
   PARM_MEMO            VARCHAR2(300),
   PARM_CREATE_TIME     DATE                 not null,
   PARM_UPDATE_TIME     DATE                 not null,
   constraint PK_PARK_ADMIN_ROLE_MENU primary key (PARM_ID)
);

comment on column PARK_ADMIN_ROLE_MENU.PARM_ID is
'用户角色权限ID';

comment on column PARK_ADMIN_ROLE_MENU.PARM_PAR_ID is
'用户角色菜单权限';

comment on column PARK_ADMIN_ROLE_MENU.PARM_MENU_ID is
'界面ID';

comment on column PARK_ADMIN_ROLE_MENU.PARM_STATE is
'状态';

comment on column PARK_ADMIN_ROLE_MENU.PARM_MEMO is
'备注';

comment on column PARK_ADMIN_ROLE_MENU.PARM_CREATE_TIME is
'创建时间';

comment on column PARK_ADMIN_ROLE_MENU.PARM_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_AMOUNT_LOG                                       */
/*==============================================================*/
create table PARK_AMOUNT_LOG 
(
   PAL_ID               NUMBER(10)           not null,
   PAL_PA_ID            NUMBER(10)           not null,
   PAL_PC_NUM           VARCHAR2(100),
   PAL_MONEY            NUMBER(10)           not null,
   PAL_DESC             VARCHAR2(100)        not null,
   PAL_STATE            NUMBER(1)            not null,
   PAL_MEMO             VARCHAR2(100),
   PAL_CREATE_TIME      DATE                 not null,
   constraint PK_PARK_AMOUNT_LOG primary key (PAL_ID)
);

comment on column PARK_AMOUNT_LOG.PAL_ID is
'流水id';

comment on column PARK_AMOUNT_LOG.PAL_PA_ID is
'管理员id';

comment on column PARK_AMOUNT_LOG.PAL_PC_NUM is
'车牌号';

comment on column PARK_AMOUNT_LOG.PAL_MONEY is
'收费金额';

comment on column PARK_AMOUNT_LOG.PAL_DESC is
'收费内容';

comment on column PARK_AMOUNT_LOG.PAL_STATE is
'状态';

comment on column PARK_AMOUNT_LOG.PAL_MEMO is
'备注';

comment on column PARK_AMOUNT_LOG.PAL_CREATE_TIME is
'创建时间';

/*==============================================================*/
/* Table: PARK_CARNUM                                           */
/*==============================================================*/
create table PARK_CARNUM 
(
   PC_ID                NUMBER(10)           not null,
   PC_PCR_ID            NUMBER(10)           not null,
   PC_NUM               VARCHAR2(100)        not null,
   PC_PHOTO_URL         VARCHAR2(300)        not null,
   PC_STATE             NUMBER(1)            not null,
   PC_MEMO              VARCHAR2(300),
   PC_CREATE_TIME       DATE                 not null,
   PC_UPDATE_TIME       DATE                 not null,
   constraint PK_PARK_CARNUM primary key (PC_ID)
);

comment on column PARK_CARNUM.PC_ID is
'车牌ID';

comment on column PARK_CARNUM.PC_PCR_ID is
'车牌角色ID';

comment on column PARK_CARNUM.PC_NUM is
'车牌号';

comment on column PARK_CARNUM.PC_PHOTO_URL is
'车辆照片路径';

comment on column PARK_CARNUM.PC_STATE is
'状态';

comment on column PARK_CARNUM.PC_MEMO is
'备注';

comment on column PARK_CARNUM.PC_CREATE_TIME is
'创建时间';

comment on column PARK_CARNUM.PC_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_CAR_RECORD                                       */
/*==============================================================*/
create table PARK_CAR_RECORD 
(
   PCRD_ID              NUMBER(10)           not null,
   PCRD_PC_ID           NUMBER(10)           not null,
   PCRD_COME_TIME       DATE                 not null,
   PCRD_OUT_TIME        DATE,
   PCRD_STATE           NUMBER(1)            not null,
   PCRD_MEMO            VARCHAR2(100),
   PCRD_CREATE_TIME     DATE                 not null,
   PCRD_UPDATE_TIME     DATE                 not null,
   constraint PK_PARK_CAR_RECORD primary key (PCRD_ID)
);

comment on column PARK_CAR_RECORD.PCRD_ID is
'车辆出入ID';

comment on column PARK_CAR_RECORD.PCRD_PC_ID is
'车牌id';

comment on column PARK_CAR_RECORD.PCRD_COME_TIME is
'车辆进入时间';

comment on column PARK_CAR_RECORD.PCRD_OUT_TIME is
'车辆离开时间';

comment on column PARK_CAR_RECORD.PCRD_STATE is
'状态';

comment on column PARK_CAR_RECORD.PCRD_MEMO is
'备注';

comment on column PARK_CAR_RECORD.PCRD_CREATE_TIME is
'创建时间';

comment on column PARK_CAR_RECORD.PCRD_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_CAR_ROLE                                         */
/*==============================================================*/
create table PARK_CAR_ROLE 
(
   PCR_ID               NUMBER(10)           not null,
   PCR_NAME             VARCHAR2(100)        not null,
   PCR_STATE            NUMBER(1)            not null,
   PCR_MEMO             VARCHAR2(100),
   PCR_CREATE_TIME      DATE                 not null,
   PCR_UPDATE_TIME      DATE                 not null,
   constraint PK_PARK_CAR_ROLE primary key (PCR_ID)
);

comment on column PARK_CAR_ROLE.PCR_ID is
'车辆角色ID';

comment on column PARK_CAR_ROLE.PCR_NAME is
'角色名';

comment on column PARK_CAR_ROLE.PCR_STATE is
'状态';

comment on column PARK_CAR_ROLE.PCR_MEMO is
'备注';

comment on column PARK_CAR_ROLE.PCR_CREATE_TIME is
'创建时间';

comment on column PARK_CAR_ROLE.PCR_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_CAR_SERVICE                                      */
/*==============================================================*/
create table PARK_CAR_SERVICE 
(
   PCS_ID               NUMBER(10)           not null,
   PCS_PC_ID            NUMBER(10)           not null,
   PCS_PMP_ID           NUMBER(10)           not null,
   PCS_STATE            NUMBER(1),
   PCS_MEMO             VARCHAR2(100),
   PCS_CREATE_TIME      DATE,
   PCS_UPDATE_TIME      DATE,
   constraint PK_PARK_CAR_SERVICE primary key (PCS_ID)
);

comment on column PARK_CAR_SERVICE.PCS_ID is
'车牌月缴业务ID';

comment on column PARK_CAR_SERVICE.PCS_PC_ID is
'车牌ID';

comment on column PARK_CAR_SERVICE.PCS_PMP_ID is
'业务ID';

comment on column PARK_CAR_SERVICE.PCS_STATE is
'状态';

comment on column PARK_CAR_SERVICE.PCS_MEMO is
'备注';

comment on column PARK_CAR_SERVICE.PCS_CREATE_TIME is
'创建时间';

comment on column PARK_CAR_SERVICE.PCS_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_CONFIGURE                                        */
/*==============================================================*/
create table PARK_CONFIGURE 
(
   PCF_ID               NUMBER(10)           not null,
   PCF_NAME             VARCHAR2(100)        not null,
   PCF_PARAMETER        VARCHAR2(100)        not null,
   PCF_STATE            NUMBER(1)            not null,
   PCF_MEMO             VARCHAR2(100),
   PCF_CREATE_TIME      DATE                 not null,
   PCF_UPDATE_TIME      DATE                 not null,
   constraint PK_PARK_CONFIGURE primary key (PCF_ID)
);

comment on column PARK_CONFIGURE.PCF_ID is
'配置ID';

comment on column PARK_CONFIGURE.PCF_NAME is
'配置名';

comment on column PARK_CONFIGURE.PCF_PARAMETER is
'配置参数';

comment on column PARK_CONFIGURE.PCF_STATE is
'配置状态';

comment on column PARK_CONFIGURE.PCF_MEMO is
'配置备注';

comment on column PARK_CONFIGURE.PCF_CREATE_TIME is
'配置创建时间';

comment on column PARK_CONFIGURE.PCF_UPDATE_TIME is
'配置更新时间';

/*==============================================================*/
/* Table: PARK_DAILY_ACCOUNT                                    */
/*==============================================================*/
create table PARK_DAILY_ACCOUNT 
(
   PDA_ID               NUMBER(10)           not null,
   PDA_TIME             VARCHAR2(20)         not null,
   PDA_MONEY            NUMBER(10)           not null,
   PDA_STATE            NUMBER(1)            not null,
   PDA_MEMO             VARCHAR2(100),
   PDA_CREATE_TIME      DATE                 not null,
   constraint PK_PARK_DAILY_ACCOUNT primary key (PDA_ID)
);

comment on column PARK_DAILY_ACCOUNT.PDA_ID is
'账单ID';

comment on column PARK_DAILY_ACCOUNT.PDA_TIME is
'结算时段';

comment on column PARK_DAILY_ACCOUNT.PDA_MONEY is
'结算金额';

comment on column PARK_DAILY_ACCOUNT.PDA_STATE is
'状态';

comment on column PARK_DAILY_ACCOUNT.PDA_MEMO is
'备注';

comment on column PARK_DAILY_ACCOUNT.PDA_CREATE_TIME is
'创建时间';

/*==============================================================*/
/* Table: PARK_DAY_SUM                                          */
/*==============================================================*/
create table PARK_DAY_SUM 
(
   PDS_ID               NUMBER(10)           not null,
   PDS_TIME             DATE                 not null,
   PDS_MONEY            NUMBER(10)           not null,
   PDS_STATE            NUMBER(1)            not null,
   PDS_MEMO             VARCHAR2(100),
   PDS_CREATE_TIME      DATE                 not null,
   constraint PK_PARK_DAY_SUM primary key (PDS_ID)
);

comment on column PARK_DAY_SUM.PDS_ID is
'日结ID';

comment on column PARK_DAY_SUM.PDS_TIME is
'日结时间';

comment on column PARK_DAY_SUM.PDS_MONEY is
'日结金额';

comment on column PARK_DAY_SUM.PDS_STATE is
'日结状态';

comment on column PARK_DAY_SUM.PDS_MEMO is
'日结备注';

comment on column PARK_DAY_SUM.PDS_CREATE_TIME is
'日结创建时间';

/*==============================================================*/
/* Table: PARK_FEE_RULE                                         */
/*==============================================================*/
create table PARK_FEE_RULE 
(
   PFR_ID               NUMBER(10)           not null,
   PFR_TIME             VARCHAR2(300)        not null,
   PFR_MONEY            NUMBER(10)           not null,
   PFR_STATE            NUMBER(1)            not null,
   PFR_MEMO             VARCHAR2(300),
   PFR_CREATE_TIME      DATE                 not null,
   PFR_UPDATE_TIME      DATE                 not null,
   constraint PK_PARK_FEE_RULE primary key (PFR_ID)
);

comment on column PARK_FEE_RULE.PFR_ID is
'计费规则ID';

comment on column PARK_FEE_RULE.PFR_TIME is
'计费时间';

comment on column PARK_FEE_RULE.PFR_MONEY is
'收费金额';

comment on column PARK_FEE_RULE.PFR_STATE is
'状态';

comment on column PARK_FEE_RULE.PFR_MEMO is
'备注';

comment on column PARK_FEE_RULE.PFR_CREATE_TIME is
'创建时间';

comment on column PARK_FEE_RULE.PFR_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_LOG                                              */
/*==============================================================*/
create table PARK_LOG 
(
   PL_ID                NUMBER(10)           not null,
   PA_ID                NUMBER(10),
   PL_DESC              VARCHAR2(300)        not null,
   PL_STATE             NUMBER(1)            not null,
   PL_MEMO              VARCHAR2(100),
   PL_CREATE_TIME       DATE                 not null,
   constraint PK_PARK_LOG primary key (PL_ID)
);

comment on column PARK_LOG.PL_ID is
'日志ID';

comment on column PARK_LOG.PA_ID is
'操作人ID';

comment on column PARK_LOG.PL_DESC is
'日志内容';

comment on column PARK_LOG.PL_STATE is
'状态';

comment on column PARK_LOG.PL_MEMO is
'备注';

comment on column PARK_LOG.PL_CREATE_TIME is
'创建时间';

/*==============================================================*/
/* Table: PARK_MACHINE_LOG                                      */
/*==============================================================*/
create table PARK_MACHINE_LOG 
(
   PML_ID               NUMBER(10)           not null,
   PML_PSM_ID           NUMBER(10)           not null,
   PML_PC_NUM           VARCHAR2(100)        not null,
   PML_MONEY            NUMBER(10)           not null,
   PML_DESC             VARCHAR2(100),
   PML_STATE            NUMBER(1)            not null,
   PML_MEMO             VARCHAR2(100),
   PML_CREATE_TIME      DATE                 not null,
   constraint PK_PARK_MACHINE_LOG primary key (PML_ID)
);

comment on column PARK_MACHINE_LOG.PML_ID is
'收费端ID';

comment on column PARK_MACHINE_LOG.PML_PSM_ID is
'自助终端ID';

comment on column PARK_MACHINE_LOG.PML_PC_NUM is
'车牌号';

comment on column PARK_MACHINE_LOG.PML_MONEY is
'收费金额';

comment on column PARK_MACHINE_LOG.PML_DESC is
'收费内容';

comment on column PARK_MACHINE_LOG.PML_STATE is
'收费状态';

comment on column PARK_MACHINE_LOG.PML_MEMO is
'收费备注';

comment on column PARK_MACHINE_LOG.PML_CREATE_TIME is
'收费创建时间';

/*==============================================================*/
/* Table: PARK_MENU                                             */
/*==============================================================*/
create table PARK_MENU 
(
   PM_ID                NUMBER(10)           not null,
   PM_PARENT            NUMBER(10)           not null,
   PM_NAME              VARCHAR2(100 )       not null,
   PM_URL               VARCHAR2(100)        not null,
   PM_STATE             NUMBER(10)           not null,
   PM_MEMO              VARCHAR2(100),
   PM_CREATE_TIME       DATE                 not null,
   PM_UPDATE_TIME       DATE                 not null,
   constraint PK_PARK_MENU primary key (PM_ID)
);

comment on column PARK_MENU.PM_ID is
'菜单ID';

comment on column PARK_MENU.PM_PARENT is
'父菜单ID';

comment on column PARK_MENU.PM_NAME is
'菜单名称';

comment on column PARK_MENU.PM_URL is
'菜单URL';

comment on column PARK_MENU.PM_STATE is
'菜单状态';

comment on column PARK_MENU.PM_MEMO is
'备注';

comment on column PARK_MENU.PM_CREATE_TIME is
'菜单创建时间';

comment on column PARK_MENU.PM_UPDATE_TIME is
'菜单修改时间';

/*==============================================================*/
/* Table: PARK_MONTH_PRODUCT                                    */
/*==============================================================*/
create table PARK_MONTH_PRODUCT 
(
   PMP_ID               NUMBER(10)           not null,
   PMP_NAME             VARCHAR2(50)         not null,
   PMP_MONTH            NUMBER(2)            not null,
   PMP_MONEY            NUMBER(10)           not null,
   PMP_STATE            NUMBER(1)            not null,
   PMP_MEMO             VARCHAR2(100),
   PMP_CREATE_TIME      DATE                 not null,
   PMP_UPDATE_TIME      DATE                 not null,
   constraint PK_PARK_MONTH_PRODUCT primary key (PMP_ID)
);

comment on column PARK_MONTH_PRODUCT.PMP_ID is
'产品ID';

comment on column PARK_MONTH_PRODUCT.PMP_NAME is
'产品名';

comment on column PARK_MONTH_PRODUCT.PMP_MONTH is
'产品月数';

comment on column PARK_MONTH_PRODUCT.PMP_MONEY is
'产品金额';

comment on column PARK_MONTH_PRODUCT.PMP_STATE is
'状态';

comment on column PARK_MONTH_PRODUCT.PMP_MEMO is
'备注';

comment on column PARK_MONTH_PRODUCT.PMP_CREATE_TIME is
'创建时间';

comment on column PARK_MONTH_PRODUCT.PMP_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_PLACE                                            */
/*==============================================================*/
create table PARK_PLACE 
(
   PP_ID                NUMBER(10)           not null,
   PP_PS_ID             NUMBER(10)           not null,
   PP_NUMBER            VARCHAR2(50)         not null,
   PP_URL               VARCHAR2(100)        not null,
   PP_STATE             NUMBER(1)            not null,
   PP_MEMO              VARCHAR2(300),
   PP_CREATE_TIME       DATE                 not null,
   PP_UPDATE_TIME       DATE                 not null,
   constraint PK_PARK_PLACE primary key (PP_ID)
);

comment on column PARK_PLACE.PP_ID is
'车位ID';

comment on column PARK_PLACE.PP_PS_ID is
'分区ID';

comment on column PARK_PLACE.PP_NUMBER is
'车位号';

comment on column PARK_PLACE.PP_URL is
'车位照片路径';

comment on column PARK_PLACE.PP_STATE is
'状态';

comment on column PARK_PLACE.PP_MEMO is
'备注';

comment on column PARK_PLACE.PP_CREATE_TIME is
'创建时间';

comment on column PARK_PLACE.PP_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_SELF_MACHINE                                     */
/*==============================================================*/
create table PARK_SELF_MACHINE 
(
   PSM_ID               NUMBER(10)           not null,
   PSM_NUM              VARCHAR2(100)        not null,
   PSM_STATE            NUMBER(1)            not null,
   PSM_MEMO             VARCHAR2(100),
   PSM_CREATE_TIME      DATE                 not null,
   PSM_UPDATE_TIME      DATE                 not null,
   constraint PK_PARK_SELF_MACHINE primary key (PSM_ID)
);

comment on column PARK_SELF_MACHINE.PSM_ID is
'自助终端ID';

comment on column PARK_SELF_MACHINE.PSM_NUM is
'自助终端名';

comment on column PARK_SELF_MACHINE.PSM_STATE is
'自助终端状态';

comment on column PARK_SELF_MACHINE.PSM_MEMO is
'自助终端备注';

comment on column PARK_SELF_MACHINE.PSM_CREATE_TIME is
'自助终端创建时间';

comment on column PARK_SELF_MACHINE.PSM_UPDATE_TIME is
'自助终端更新时间';

/*==============================================================*/
/* Table: PARK_SUBAREA                                          */
/*==============================================================*/
create table PARK_SUBAREA 
(
   PS_ID                NUMBER(10)           not null,
   PS_NAME              VARCHAR2(100)        not null,
   PS_FLOOR             VARCHAR2(100)        not null,
   PS_STATE             NUMBER(1)            not null,
   PS_MEMO              VARCHAR2(100 ),
   PS_CREATE_TIME       DATE,
   PS_UPDATE_TIME       DATE                 not null,
   constraint PK_PARK_SUBAREA primary key (PS_ID)
);

comment on column PARK_SUBAREA.PS_ID is
'分区ID';

comment on column PARK_SUBAREA.PS_NAME is
'分区名称';

comment on column PARK_SUBAREA.PS_FLOOR is
'分区楼层';

comment on column PARK_SUBAREA.PS_STATE is
'分区状态';

comment on column PARK_SUBAREA.PS_MEMO is
'分区备注';

comment on column PARK_SUBAREA.PS_CREATE_TIME is
'创建时间';

comment on column PARK_SUBAREA.PS_UPDATE_TIME is
'修改时间';

/*==============================================================*/
/* Table: PARK_WHITE_LIST                                       */
/*==============================================================*/
create table PARK_WHITE_LIST 
(
   PWL_ID               NUMBER(10)           not null,
   PWL_CARNUM           VARCHAR2(100)        not null,
   PWL_STATE            NUMBER(1)            not null,
   PWL_MEMO             VARCHAR2(100),
   PWL_CREATE_TIME      DATE                 not null,
   PWL_UPDATE_TIME      DATE                 not null,
   constraint PK_PARK_WHITE_LIST primary key (PWL_ID)
);

comment on column PARK_WHITE_LIST.PWL_ID is
'白名单ID';

comment on column PARK_WHITE_LIST.PWL_CARNUM is
'车牌号';

comment on column PARK_WHITE_LIST.PWL_STATE is
'白名单状态';

comment on column PARK_WHITE_LIST.PWL_MEMO is
'白名单备注';

comment on column PARK_WHITE_LIST.PWL_CREATE_TIME is
'白名单创建时间';

comment on column PARK_WHITE_LIST.PWL_UPDATE_TIME is
'白名单修改时间';

