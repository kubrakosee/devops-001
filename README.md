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
### ========kendi projemizi Docker image haline çevimek =============

```
docker build  --build-arg JAR_FILE=target/devops-001-hello-1.0.1-SNAPSHOT.jar   --tag    kubrakosee/devops-001-hello:v001   .
```
```
docker build  --build-arg JAR_FILE=target/devops-001-hello-1.0.2-SNAPSHOT.jar   --tag    kubrakosee/devops-001-hello:v002   .
```

```
docker build  --build-arg JAR_FILE=target/devops-001-hello-1.0.2.jar   --tag    kubrakosee/devops-001-hello:latest   .
```
### ============= kendi projemizi Docker image'den container haline çevimek =============
```
docker run     -it     -d     -p 8081:5757     --name my-app1      kubrakosee/devops-001-hello

docker run     -it     -d     -p 8082:5757     --name my-app2      kubrakosee/devops-001-hello

docker run     -it     -d     -p 8083:5757     --name my-app3      kubrakosee/devops-001-hello:v001

docker run     -it     -d     -p 8084:5757     --name my-app4      kubrakosee/devops-001-hello:v002

docker run     -it     -d     -p 8085:5757     --name my-app5      kubrakosee/devops-001-hello:latest
```
### ============= Docker Hub'dan image çekmek =============
```
docker pull kubrakosee/devops-001-hello:v001

docker pull kubrakosee/devops-001-hello:v002

docker pull kubrakosee/devops-001-hello:latest

docker pull kubrakosee/devops-001-hello
```
### ================== network ==============
# ==networkleri listele==
```
docker network ls
```
### ====yeni bir network oluştur ==============
```
docker network create my-network
```
# ===network tipini değiştirmek istiyorsanız --driver parametresi====
```
docker network create --driver host
```
# =====network bilgisi ve onu kullanan containerlar===
```
docker network inspect my-network
```

# =======networke container ekleme ===
```
docker network connect my-network my-app1
docker network connect my-network my-app2
docker network connect my-network my-app3
docker network connect my-network my-app4
```
# =====network bilgisi ve onu kullanan containerlar ======
```
docker network inspect my-network
```

# ==========networke container çıkarma==========
```
docker network disconnect my-app4
```
# ====network bilgisi ve onu kullanan containerlar
```
docker network inspect my-network
```
# ====networkü silme
```
docker network rm my-network
```
# ============== volume ==============
```
docker volume ls
```

# ======Yeni bir volume oluşturmak
```
docker volume create my-volume
```

```docker volume ls```

```docker volume inspect my-volume```

# ====bir volume silmek
```
docker volume rm my-volume
```
# =====kullanılmayan tüm volumeleri silmek
```docker volume prune```

# ============= docker-compose ===================
```
docker compose -f docker-compose.yml up
```
```
docker ps
docker container ls
docker-compose logs mongo
docker-compose logs -f  mongo
docker compose -f docker-compose.yml down
```
# ============ Kubernetes ===========
# =Docker Hub'daki imajı, yerel makinemde Docker kullanarak çekiyor ve bir container olarak çalıştırıyorum.
```
docker run     -it     -d     -p 8085:8080     --name my-app5      kubrakosee/devops-001-hello:latest
```

# ==Docker Hub'dan imajı container olarak çekip Kubernetes'teki Pod içinde çalıştırıyorum.
```
kubectl run my-pod1 --image=kubrakosee/devops-001-hello:latest

kubectl run my-pod2 --image=kubrakosee/devops-001-hello:v001
kubectl run my-pod3 --image=kubrakosee/devops-001-hello:v002
kubectl run my-pod4 --image=kubrakosee/devops-001-hello:v002
kubectl run my-pod5 --image=kubrakosee/devops-001-hello:latest
kubectl run my-pod6 --image=kubrakosee/devops-001-hello:latest
kubectl run my-pod7 --image=kubrakosee/devops-001-hello:v003
kubectl run my-pod8 --image=mysql
kubectl run my-pod9 --image=postgres
kubectl get nodes
kubectl get node
kubectl get pods
kubectl get pod
```
### ===Pods
## ==Deployment
# ===Service