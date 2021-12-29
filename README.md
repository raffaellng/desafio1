# desafio 1
Um desafio de criar um Crud em java usando algumas config.


Subir o projeto no github usando \
  -Docker\
  -Flyway\
  -Java 17\
  -Springboot


# O projeto
O projeto deve disponibilizar um crud de chave pix.\
Todos os métodos tem que estar expostos via API https. Utilizar o segundo nível de maturidade rest.\
Banco de dados tem que subir via docker.\
Utilizar database migration, como flyway para execução dos scripts do banco de dados.\
Commitar todo dia o que tem feito no projeto para acompanhamento.\
Escolher um design pattern que será implementado na solução 

# design pattern


# Docker
docker run --name desafio-db -e POSTGRES_USER=user -e POSTGRES_PASSWORD=12345678 -e POSTGRES_DB=desafio1 -p 5432:5432 -d postgres

