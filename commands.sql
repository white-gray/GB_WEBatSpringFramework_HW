select * from gb_springlessons_hw.products;
select * from gb_springlessons_hw.cart;
select * from gb_springlessons_hw.t_role;
select * from gb_springlessons_hw.t_user;
select * from gb_springlessons_hw.t_user_roles;
select * from gb_springlessons_hw.t_user_cart;

INSERT INTO public.t_role(id, name)
  VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

SELECT * FROM gb_springlessons_hw.products WHERE name= "Prod2";

truncate gb_springlessons_hw.cart;

insert into gb_springlessons_hw.products (name, price) value ('Prod1', '22.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod2', '222.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod3', '2332.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod4', '12.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod5', '22.2'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod6', '322.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod7', '212.323'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod8', '22.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod9', '22.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod10', '262.3'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod11', '232.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod12', '322.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod13', '22.2'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod14', '212.0'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod15', '252.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod16', '227.133'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod17', '262.3'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod18', '22.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod19', '272.343'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod20', '2288.33'); 
insert into gb_springlessons_hw.products (name, price) value ('Prod21', '2.0');  

DELETE FROM gb_springlessons_hw.cart WHERE id = 11;
DELETE FROM gb_springlessons_hw.cart WHERE id = 12;
DELETE FROM gb_springlessons_hw.cart WHERE id = 13;
DELETE FROM gb_springlessons_hw.cart WHERE id =14;
DELETE FROM gb_springlessons_hw.cart WHERE id = null;
DELETE FROM gb_springlessons_hw.products WHERE id = 8;
DELETE FROM gb_springlessons_hw.products WHERE id = 9;
DELETE FROM gb_springlessons_hw.products WHERE id = 10;
DELETE FROM gb_springlessons_hw.products WHERE id = 11;
