# recommend you only filter the suggest maindexlist, use -suggest-split and -suggest-keep.
# It will merge global filter if -filter-suggest is ENABLE.
#  进行注释, 当行起始加上 #, 这行配置被禁用.


-keep android.support.multidex.**
-keep com.nicaiya.dexknife.demo.App.class
-keep com.nicaiya.dexknife.demo.App$*.class



# Global filter, don't apply with suggest maindexlist if -filter-suggest is DISABLE.
# this path will to be split to second dex.
#-split android.support.v?.**

#-split **.Main2Activity.class

-keep **.Test.class


#**.MainActivity2.class
#**.MainActivity2$*.class   # use $* to filter the inner classes.

# if you want to keep some classes in main dex, use '-keep'.
#-keep android.support.v4.view.**


#-keep android.support.multidex.**

# you can keep single class in main dex, use '-keep'.
#-keep android.support.v7.app.AppCompatDialogFragment.class

# do not use suggest of the maindexlist that android gradle plugin generate.
-donot-use-suggest

# the global filter apply with maindexlist, if -donot-use-suggest is DISABLE.
#-filter-suggest

# without --minimal-main-dex, only spliting at dex id > 65536 . --minimal-main-dex is default
#-auto-maindex

# log the main dex classes.
#-log-mainlist

# log the filter list for suggest classes of maindexlist, if -filter-suggest is enabled.
-log-filter-suggest

-split **.**

#-dex-param --set-max-idx-number=2000

