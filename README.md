# Example of Authenticator SPI and Custom Theme

## ビルドとデプロイ

localhost:8080 でRH-SSO 7.6 (もしくはKeycloak Legacy 18.0)が稼働していること。

```shell
# Authenticator SPI のビルドとデプロイ
$ cd authenticator
$ mvn package wildfly:deploy

# カスタムテーマのビルドとデプロイ
$ cd ../theme
$ mvn package wildfly:deploy
```

## 設定

テスト用のレルムを作成しそこに設定を行う。

基本的に Authenticator SPI の元である秘密の質問の例の [README.md](https://github.com/keycloak/keycloak/tree/18.0.2/examples/providers/authenticator) と同じである。

1. 認証フローでデフォルトのブラウザをコピーし、"Secret Question"をREQUIREDで追加。
2. Required Actionsで"Secret Question"を設定し秘密の質問の設定を強制。
3. ログインテーマを（このカスタマイズ用のHTMLテンプレートを含む）"secret-question"に設定。

テスト用のユーザを作成し、アカウント管理コンソール (http://localhost:8080/auth/realms/test-realm/account/) にログインしてみて動作を確認する。

# User Storage SPI

Quickstartsよりuser-storage-simpleとuser-storage-jpaをコピー。
それぞれ以下の方法でビルド(Java 17では失敗するので8か11を使う)およびデプロイし、User Federationタブで設定して使用する。

```sehll
$ cd ../user-storage-simple
$ JAVA_HOME=/usr/lib/jvm/jre-11 mvn package wildfly:deploy -Dkeycloak.management.port=9990

$ cd ../user-storage-jpa
$ JAVA_HOME=/usr/lib/jvm/jre-11 mvn -Padd-datasource install -Dkeycloak.management.port=9990
$ JAVA_HOME=/usr/lib/jvm/jre-11 mvn package wildfly:deploy -Dkeycloak.management.port=9990
```

