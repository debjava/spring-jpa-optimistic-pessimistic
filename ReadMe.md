# To check all the tables in a schema in postgress

```
SELECT * FROM pg_catalog.pg_tables WHERE schemaname='public';
```

Delete the following tables before performing ops

`DROP TABLE IF EXISTS public.product CASCADE;`