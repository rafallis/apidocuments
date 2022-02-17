# Document API

<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?logo=java&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?logo=docker&logoColor=white)
[![GitHub forks](https://img.shields.io/github/forks/rafallis/apidocuments)](https://github.com/rafallis/apidocuments/network)
[![GitHub license](https://img.shields.io/github/license/rafallis/apidocuments)](https://github.com/rafallis/apidocuments/blob/main/LICENSE.md)

> API for inserting documents into database and using MQTT messaging to trigger indexing of these documents in elasticsearch

> This project also has a Vue frontend for testing [FRONTEND](https://github.com/rafallis/frontend-apidocuments) and a api to index documents on [ElasticSearch](https://github.com/rafallis/idx-documents)

### Steps

The project is still under development. See above:

- [x] CRUD Document
- [x] Send message to RabbitMQTT with Document Object
- [ ] Trigger elasticsearch indexing api
- [ ] Write unit tests

## 💻 Project requirements


* `Maven 3.8`
* `Java 17`
* `Docker | Docker-compose`
* `MySQL 5.6`

## 🚀 Run the Project

Run `docker-compose.yml` to initializae MySQL database and RabbitMQ broker:
```
docker-compose up -d
```

Build and run Spring Boot project
```
mvn clean install
mvn spring-boot:run
```

## ☕ Endpoints

UNDER CONSTRUCION

## 📝 License

This project is under GNU GPL V3.0 License [LICENSE](LICENSE.md) for details.

[⬆ Voltar ao topo](#document-api)<br>