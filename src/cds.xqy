for $cd in doc("cd_catalog")/CATALOG/CD
where $cd/PRICE<10
return $cd