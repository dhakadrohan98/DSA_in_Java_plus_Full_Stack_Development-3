1. product search engine schema design()


Product                 
pId (pk)
pName (Varchar-50)
pDescription (varchar 256)
price (decimal (12,2))
type(portable- bool)
isVirtual- bool
unit (negative values)
weight

product_category (main & sub category)
type_id (pk)
type_name
{ Constraint- type_id + pId = unique }

productMappingWithCategory
type_id
pId

Inventory
invt_id(pk)
Pid (fk to product)
Quantity


What is the bug? 
Ans- Writing bug -> inner join product_category rather than productMappingWithCategory
What is total number of product available under each category?
Ans-
select pc.name, count(*) as productCount from productMappingWithCategory pmc
inner join productMappingWithCategory pmc on pmc.type_id = pc.type_id
group by pmc.type_id;


What is the bug ?
Ans- Writing bug logical query is good & will give expected result?
Find all products which are under electronic category & their available quantities >= 5.
Ans-
select p.name from product p
inner join productMappingWithCategory PMC on pmc.Pid = p.pId
inner join product_category on pc.type_id = PMC.type_id
inner join Inventory i on i.pId = p.id
where pc.type_name = 'electronics' and i.quantity >= 5


electronics = 1, pId= 101,104,107
productMappingWithCategory
1  101
1  104
1  107



