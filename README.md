# DOCKER

### ============= docker login =============
```
docker login   --username kubrakosee     --password 123456789

docker login   -u         kubrakosee     -p        123456789
```

### ============= nginx ============= DIŞ_PORT:İÇ_PORT
```
docker run     -it     -d     -p 9991:80     --name my-nginx      nginx
```
```
http://localhost:9991
```

### ============= postgres =============
```
docker run  --name my-postgres   -p 9999:5432  -e POSTGRES_PASSWORD=123456789  -d  postgres
```
###  ============= mysql =============
```
docker run  --name my-mysql      -p 9990:3306  -e MYSQL_ROOT_PASSWORD=123456789 -d  mysql
```
