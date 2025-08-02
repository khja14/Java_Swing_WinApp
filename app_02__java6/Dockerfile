FROM openjdk:6

WORKDIR /app

# /source以下のソースをまとめてコピー
COPY source/ ./

# コンパイル
RUN javac MyApp.java

# マニフェストにメインクラス指定
RUN echo Main-Class: MyApp > manifest.txt

# jar作成
RUN jar cfm MyApp.jar manifest.txt *.class

# 実行はしない（jarをホストにコピーするだけ）
