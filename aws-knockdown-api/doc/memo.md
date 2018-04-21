# memo

## 現状の課題

* `@EnableRdsInstance`が、起動クラス`CloudKnockdownApiApplication`じゃないと、うまく読み込めない
* awsのautoconfigureをexcludeする場合、プロファイル指定のapplication.ymlに記載しても、うまくいかない。