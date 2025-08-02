FROM openjdk:21

WORKDIR /app

# /source以下のソースをまとめてコピー
COPY source/ ./

# コンパイル
RUN javac MyCustomButton.java Main.java

# マニフェストにメインクラス指定
RUN echo Main-Class: Main > manifest.txt

# jar作成
RUN jar cfm MyApp.jar manifest.txt *.class

# 実行はしない（jarをホストにコピーするだけ）
