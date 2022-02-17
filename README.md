# Document API

<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)

> API for inserting documents into database and using MQTT messaging to trigger indexing of these documents in elasticsearch

> This project also has a Vue frontend for testing. See: [FRONTEND](https://google.com)

### Steps

The project is still under development. See above:

- [x] CRUD Document
- [x] Send message to RabbitMQTT with document ID to be indexed
- [ ] Trigger elasticsearch indexing
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