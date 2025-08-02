@REM なんかBatからだと動かないから、↓のコマンドを手動で実行すること。
@REM "管理者権限で起動した""PowerShell"で実行すること。

@REM Java6をjabbaで使うための設定
jabba --version
jabba link system@1.6.0 "C:\Progra~1\Java\jdk1.6.0_41"

@REM Java6へ切り替え
jabba use system@1.6.0
java -version
