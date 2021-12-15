create table Animals(
Animal_id number(5) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
Animal_type varchar2(20) not null ,
Animal_name varchar2(50) not null ,
Animal_gender varchar2(10) not null,
Animal_dob date,
Animal_Description varchar2(1000),
Animal_color varchar2(20),
Animal_price number(12,2) CONSTRAINT Animalprice check (Animal_price>0),
Animal_image blob,
Status varchar2(30) default 'Not approved',
Customer_id number(5) not null,
admin_id number(5) default 0,
Animal_register date default (sysdate));


create table Animals_Customers (
Customer_id number(5) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
Customer_firstname VARCHAR2(32) Not null,
Customer_lastname VARCHAR2(32) Not null,
Customer_gender varchar2(10) default 'male',
Customer_username VARCHAR2(32) UNIQUE not null,
Customer_password varchar2(32) not null,
Customer_email VARCHAR2(32) unique not null,
Customer_mobilenumber number(15) not null,
Customer_image blob,
Customer_bank number(20),
Customer_reg_date date default (sysdate),
Customer_address varchar2(300),
Customer_pincode number(8));
      
select * from Animals_customers;   

create table animals_orders(
Order_id number(5) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
Customer_id number(5) not null,
order_date date default sysdate,
price number(15,2) not null,
order_status varchar2(20) default 'NotDelivered',
CONSTRAINT FK_OrderCustomerId foreign key(Customer_id) REFERENCES animals_customers(Customer_id));

drop table animals_orders;    
create table animal_orderitems(
item_id number(5)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
order_id number(5) not null,
Animal_id number(5) not null,
Quantity number(5) not NULL,
unit_price number(10,2) not null,
total_price number(15,2)not null,
CONSTRAINT FK_OrderItemsAnimalId foreign key(Animal_id) REFERENCES Animals(Animal_id),
CONSTRAINT FK_OrderItemsOrderId foreign key(order_id) REFERENCES animals_orders(order_id));

drop table animal_orderitems;

create table carts(
cart_id number(5) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
Customer_id number(5) not null,
CONSTRAINT FK_CartsCustomerId foreign key(Customer_id) REFERENCES Animals_Customers(Customer_id));
drop table carts;
create table cart_items(
item_id number(5) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
Animal_id number(5) not null,
cart_id number(5) not null,
Quantity number(5) not null,
unit_price number(10,2) not null,
total_price number(15,2) not null,
CONSTRAINT FK_CartItemsAnimalId foreign key(Animal_id) REFERENCES Animals(Animal_id),
CONSTRAINT FK_CartItemsCartId foreign key(Cart_id) REFERENCES carts(Cart_id));

drop table cart_items;
create table animals_employees(
Employee_id number(5) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
Employee_FirstName varchar2(32) not null,
Employee_LastName varchar2(32) not null,
Employee_gender varchar2(10) default 'male',
Employee_Dob date,
Employee_Doj date default sysdate,
employee_Email varchar2(50) not null,
employee_number number(15)not null,
employee_salary number(12,2),
employee_regdate date default (sysdate));

create table animals_Adminuser(
Admin_id number(5) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
Admin_username varchar2(32) not null UNIQUE,
admin_password varchar(32) not null,
Admin_employeeId number(5) not null,
admin_registerDate date default (sysdate),
CONSTRAINT FK_AdminEmpID foreign key(Admin_employeeId) REFERENCES animals_employees(Employee_id));

insert into animals_Adminuser(Admin_username,admin_password,Admin_employeeId,admin_registerDate) 
values('AdminHariharan96','hariharan96',1,'10-10-2020');
insert into animals_Adminuser (Admin_username,admin_password,Admin_employeeId,admin_registerDate)
values('AdminGokul95','gokul95',2,'12-09-2019');
select * from animals_customers;
desc animals_customers;
select * from animals_customers where customer_username='Hariharan96' and customer_password='hariharan96';
select * from animals_adminuser;
select * from animals_employees;
select * from animals_customers;



set serveroutput on
declare
username animals_customers.customer_username%TYPE:='&username';
password animals_customers.customer_password%TYPE:='&password';
firstname animals_customers.customer_firstname%TYPE;
begin
select e.employee_firstname into firstname 
        from animals_adminuser u
        inner join animals_employees e on u.admin_employeeid = e.employee_id
        where admin_username=username and admin_password=password;
        dbms_output.put_line('Admin firstname: ' || firstname );
EXCEPTION 
        WHEN NO_DATA_FOUND THEN
        select customer_firstname into firstname
        from animals_customers 
        where customer_username=username and customer_password=password;
        dbms_output.put_line('user firstname: ' || firstname );
end;
/
