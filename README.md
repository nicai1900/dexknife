# DexKnife 开发中

Android自动分包插件

支持Android Gradle Plugin 3.1.1及以上版本

注2：本插件是基于DexKnifePlugin 1.7.0alpha优化改造而来，感谢ceabie的无私奉献。


## 使用方法

1. 添加依赖

```groovy

    buildscript {
        dependencies {
            classpath 'com.android.tools.build:gradle:3.1.1'  // or other
            classpath 'com.nicaiya.dexkinfe:dexkinfe:1.0.0'
        }
    }

```

2. 定义配置文件

在App模块创建dexknife.pro文件，并填写要放到第二个dex中的包名路径的通配符.

```
# 使用# 进行注释, 当行起始加上 #, 这行配置被禁用.

# 全局过滤, 如果没设置 -filter-suggest 并不会应用到 建议的maindexlist.
# 如果你想要某个已被排除的包路径在maindex中，则使用 -keep 选项，即使他已经在分包的路径中.
# 注意，没有split只用keep时，miandexlist将仅包含keep指定的类。
-keep android.support.v4.view.**

# 这条配置可以指定这个包下类在第二dex中.（注意，未指定的类会在被认为在maindexlist中）
# android.support.v?.**

# 使用.class后缀，代表单个类.
-keep android.support.v7.app.AppCompatDialogFragment.class

# 不包含Android gradle 插件自动生成的miandex列表.
-donot-use-suggest

# 将 全局过滤配置应用到 建议的maindexlist中, 但 -donot-use-suggest 要关闭.
-filter-suggest

# 不进行dex分包， 直到 dex 的id数量超过 65536.
-auto-maindex

# dex 扩展参数, 例如 --set-max-idx-number=50000
# 如果出现 DexException: Too many classes in --main-dex-list, main dex capacity exceeded，则需要调大数值
-dex-param --set-max-idx-number=50000

# 显示miandex的日志.
-log-mainlist

#过滤日志。Recommend：在maindexlist中（由推荐列表确定）；Global：在maindexlist中，由全局过滤确定；true，前两者都成立的；false，不在maindexlist中
-log-filter

# 如果你只想过滤 建议的maindexlist, 使用 -suggest-split 和 -suggest-keep.
# 如果同时启用 -filter-suggest, 全局过滤会合并到它们中.
-suggest-split **.MainActivity2.class
-suggest-keep android.support.multidex.**

```

4. 在App模块的build.gradle中应用插件

```groovy

apply plugin: 'com.nicaiya.dexknife'

```

5. 编译应用
