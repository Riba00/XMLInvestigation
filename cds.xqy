for $cd in doc("cd_catalog.xml")/CATALOG/CD
where $cd/PRICE < 10
return <CD>
        <TITLE>{$cd/TITLE/string()}</TITLE>
        <PRICE>{$cd/PRICE/string()}</PRICE>
       </CD>