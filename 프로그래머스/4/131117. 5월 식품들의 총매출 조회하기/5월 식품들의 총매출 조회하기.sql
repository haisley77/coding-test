-- 코드를 입력하세요
select a.product_id, product_name, sum(amount * price) total_sales
from food_product a join food_order b on a.product_id = b.product_id
where year(produce_date) = 2022 and month(produce_date) = 5
group by a.product_id
order by total_sales desc, a.product_id