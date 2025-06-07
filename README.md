# EcoWorldAuth

EcoWorldAuth は、Minecraft/Spigot サーバー向けの包括的な権限制御プラグインです。プレイヤーのあらゆる行動を権限ベースで制御し、サーバー管理者が細かい権限設定を行えるようにします。

## 特徴

- **包括的な権限制御**: ブロックの破壊・設置からエンティティの操作まで、幅広いプレイヤー行動を制御
- **細分化された権限**: ブロックタイプ別、行動別の詳細な権限設定が可能
- **イベントログ機能**: 権限チェックイベントのログ出力機能
- **リロード機能**: サーバーを再起動せずに設定を再読み込み可能
- **EcoFramework 基盤**: 安定した独自フレームワーク上で動作

## 必要な環境

- **Minecraft**: 1.18.2 以上
- **Java**: 1.8 以上
- **依存プラグイン**: EcoFramework 0.6

## インストール

1. [EcoFramework](http://ecolight15.github.io/mvn_rep/) をダウンロードしてサーバーの `plugins` フォルダに配置
2. EcoWorldAuth プラグインファイルを `plugins` フォルダに配置
3. サーバーを再起動

## 設定

### config.yml

```yaml
# イベントログの有効/無効
event-logging: false
```

- `event-logging`: 権限チェックイベントのログ出力を有効にする場合は `true` に設定

## コマンド

### /ewa
基本コマンド

- **権限**: `ecoworldauth`
- **使用法**: `/ewa`

### /ewa reload
設定ファイルをリロード

- **権限**: `ecoworldauth.reload`  
- **使用法**: `/ewa reload`

## 権限システム

EcoWorldAuth は、以下のカテゴリで権限を管理します。権限が設定されていないプレイヤーの行動は自動的に拒否されます。

### ブロック関連権限 (ewa.block.*)

#### ブロック破壊
- **権限**: `ewa.block.break.<BLOCK_TYPE>`
- **説明**: 指定したブロックタイプの破壊を許可
- **例**: `ewa.block.break.STONE` (石ブロックの破壊を許可)

#### ブロック設置
- **権限**: `ewa.block.place.<BLOCK_TYPE>`
- **説明**: 指定したブロックタイプの設置を許可
- **例**: `ewa.block.place.WOOD` (木ブロックの設置を許可)

#### ブロックダメージ
- **権限**: `ewa.block.blockdamage.<BLOCK_TYPE>`
- **説明**: 指定したブロックタイプへのダメージを許可
- **例**: `ewa.block.blockdamage.DIAMOND_ORE` (ダイヤ鉱石へのダメージを許可)

#### ブロック着火
- **権限**: `ewa.block.blockignite.<BLOCK_TYPE>`
- **説明**: 火打ち石と打ち金による指定ブロックタイプの着火を許可
- **例**: `ewa.block.blockignite.TNT` (TNTの着火を許可)

### プレイヤー行動権限 (ewa.player.*)

- **`ewa.player.armor_stand_manipulate`**: アーマースタンドの操作を許可
- **`ewa.player.bucket_empty`**: バケツの使用（液体の流し込み）を許可
- **`ewa.player.bucket_fill`**: バケツでの液体汲み取りを許可
- **`ewa.player.drop_item`**: アイテムドロップを許可
- **`ewa.player.interact_entity`**: エンティティとの相互作用を許可
- **`ewa.player.interact_entity_frame`**: アイテムフレームとの相互作用を許可
- **`ewa.player.interact`**: 一般的な相互作用（右クリック等）を許可
- **`ewa.player.pickup_arrow`**: 矢の回収を許可

### エンティティ関連権限 (ewa.entity.*)

- **`ewa.entity.pickup_item`**: アイテムの拾得を許可
- **`ewa.entity.damage_frame`**: アイテムフレームへのダメージを許可

### インベントリ関連権限 (ewa.inventory.*)

- **`ewa.inventory.open`**: インベントリの開放を許可

### 壁掛け系権限 (ewa.hanging.*)

- **`ewa.hanging.break`**: 壁掛けアイテム（絵画、アイテムフレーム等）の破壊を許可
- **`ewa.hanging.place`**: 壁掛けアイテムの設置を許可

### 乗り物関連権限 (ewa.vehicle.*)

- **`ewa.vehicle.damage`**: 乗り物へのダメージを許可
- **`ewa.vehicle.destroy`**: 乗り物の破壊を許可
- **`ewa.vehicle.enter`**: 乗り物への乗車を許可
- **`ewa.vehicle.collision`**: 乗り物との接触を許可

## 使用例

### 基本的な権限設定

一般プレイヤーに基本的な行動を許可する例：

```yaml
permissions:
  # 基本的なブロック操作
  ewa.block.break.DIRT: true
  ewa.block.break.STONE: true
  ewa.block.place.DIRT: true
  ewa.block.place.COBBLESTONE: true
  
  # プレイヤー行動
  ewa.player.interact: true
  ewa.player.drop_item: true
  ewa.player.pickup_arrow: true
  
  # アイテム拾得
  ewa.entity.pickup_item: true
  
  # インベントリ操作
  ewa.inventory.open: true
```

### 建築者権限設定

建築に必要な権限を広範囲に許可する例：

```yaml
permissions:
  # すべてのブロック操作
  ewa.block.break.*: true
  ewa.block.place.*: true
  
  # 装飾関連
  ewa.hanging.break: true
  ewa.hanging.place: true
  ewa.player.interact_entity_frame: true
  ewa.player.armor_stand_manipulate: true
```

## ライセンス

GNU Lesser General Public License v3.0

## 作者

- **ecolight** - 開発者

## 関連プロジェクト

- [EcoFramework](http://ecolight15.github.io/mvn_rep/) - 本プラグインの基盤フレームワーク

## サポート

- バグ報告や機能要望は GitHub の Issues をご利用ください
- プル リクエストは歓迎します

## バージョン履歴

- **0.4** - 現行バージョン