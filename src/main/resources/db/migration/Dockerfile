# Определение базового образа
FROM flyway/flyway:latest

# Переход в рабочий каталог
WORKDIR /flyway

# Копирование файлов миграции SQL в контейнер
COPY . sql/

# Определение переменных окружения
ENV FLYWAY_URL="jdbc:postgresql://localhost:5432/some_db"
ENV FLYWAY_USER="some_user"
ENV FLYWAY_PASSWORD="some_password"

# Запуск команды миграции
CMD ["migrate"]