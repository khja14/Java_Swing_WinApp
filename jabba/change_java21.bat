@REM なんかBatからだと動かないから、↓のコマンドを手動で実行すること。
@REM "管理者権限で起動した""PowerShell"で実行すること。

@REM Java21をjabbaで使うための設定
jabba --version
jabba link system@21.0.0 "C:\Progra~1\Java\jdk-21"

@REM Java6へ切り替え
jabba use system@21.0.0
java -version
