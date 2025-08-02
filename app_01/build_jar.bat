@echo off
setlocal

echo === Docker イメージをビルド ===
docker build -t swing-builder .
if errorlevel 1 goto :error

echo === 一時コンテナを作成 ===
docker create --name swing-temp swing-builder
if errorlevel 1 goto :error

echo === jar をホストにコピー ===
docker cp swing-temp:/app/MyApp.jar MyApp.jar
if errorlevel 1 goto :error

echo === 一時コンテナを削除 ===
docker rm swing-temp
if errorlevel 1 goto :error

echo === 完了！MyApp.jar を作成しました ===
goto :eof

:error
echo エラーが発生しました。
exit /b 1
