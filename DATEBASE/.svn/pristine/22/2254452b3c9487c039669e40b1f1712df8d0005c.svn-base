
drop sequence SEQ_PARK_CONFIGURE;

create sequence SEQ_PARK_CONFIGURE
start with 100;



drop table PARK_CONFIGURE cascade constraints
/

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
)
/





--¼ÙÊý¾Ý

 
INSERT INTO PARK_CONFIGURE VALUES (SEQ_PARK_CONFIGURE.nextval,'temp','temp',1,null,SYSDATE,SYSDATE);
INSERT INTO PARK_CONFIGURE VALUES (SEQ_PARK_CONFIGURE.nextval,'temp1','temp',1,null,SYSDATE,SYSDATE);
INSERT INTO PARK_CONFIGURE VALUES (SEQ_PARK_CONFIGURE.nextval,'temp2','temp',1,null,SYSDATE,SYSDATE);
INSERT INTO PARK_CONFIGURE VALUES (SEQ_PARK_CONFIGURE.nextval,'temp3','temp',1,null,SYSDATE,SYSDATE);
INSERT INTO PARK_CONFIGURE VALUES (SEQ_PARK_CONFIGURE.nextval,'temp4','temp',1,null,SYSDATE,SYSDATE);
INSERT INTO PARK_CONFIGURE VALUES (SEQ_PARK_CONFIGURE.nextval,'temp5','temp',1,null,SYSDATE,SYSDATE);
INSERT INTO PARK_CONFIGURE VALUES (SEQ_PARK_CONFIGURE.nextval,'temp6','temp',1,null,SYSDATE,SYSDATE);


commit;
