
var Java = JavaImporter(
    java.lang.System,
    android.util.Log,
    android.widget.Toast,
    java.lang.Thread
)

var App = JavaImporter(
    com.nightfarmer.rhino.sample.R
)


function initAndroidContext(p){
    context=p
    activity=context
}