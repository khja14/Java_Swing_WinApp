@REM PowerSHell !!!
Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
iwr -useb https://github.com/shyiko/jabba/raw/master/install.ps1 | iex
jabba ls

@REM > jabba で OpenJDK 6 を直接インストールするコマンドは、残念ながら 公式リポジトリにOpenJDK 6はほぼ無いため
@REM > 通常の jabba install openjdk@6 のような形では存在しません
@REM チーン