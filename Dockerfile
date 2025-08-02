FROM openjdk:17

WORKDIR /app

# Java ファイルをコンテナにコピー
COPY MyApp.java .

# jar をビルド
RUN javac MyApp.java && \
    jar cfe MyApp.jar MyApp MyApp.class
