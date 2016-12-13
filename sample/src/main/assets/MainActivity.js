function onCreate(){
    Java.System.out.println("onCreate....233333")
//    Java.System.out.println(Packages)
    Java.Log.i("yooo","logtest")
    Java.Toast.makeText(context, "hehe", Java.Toast.LENGTH_SHORT).show();
    var button1 = context.findViewById(App.R.id.button1)
    button1.setText("ssss")
    button1.setOnClickListener(function(){
        button1.setText("yooo")
    })
    new Java.Thread(function(){
        for(var a = 0; a<10;a++){
            Java.Thread.sleep(1000)
            activity.runOnUiThread(function(){
                button1.setText("2333"+a)
            })
        }
    }).start()

    context.abcd(context.getAaaa())
}
