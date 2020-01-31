use jspservlet122019;
select * from building b inner join assignmentbuilding ab
on b.id = ab.buildingid where
b.name like '%building%' and b.dictrict like '%QUAN_1%'
and b.ward like '%2%' and b.numberofbasement = 2
and(b.type like '%TANG_TRET%' or b.type like '%NGUYEN_CAN%' or b.type like '%NOT_THAT%')
and exists (select * from rentarea ra where (b.id = ra.building
and ra.value <= 500 and ra.value >=300))
and b.rentcost >=1 and b.rentcost<=2
and ab.staff = 2;

select * from building b where exists (select * from rentarea ra where (b.id = ra.building and ra.value >= 500)
