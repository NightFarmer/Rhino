function onCreate() {
    System.out.println("onCreate....233333")
    Log.i("yooo", "logtest")
    var button1 = context.findViewById(R.id.button1)
    button1.setText("ssss")
    button1.setOnClickListener(function () {
        Toast.makeText(context, "hehe", Toast.LENGTH_SHORT).show();
        button1.setText("yooo")
    })
    // button1.setBackgroundColor(Color.parseColor("#ffff0000"))
    new Thread(function () {
        for (var a = 0; a < 10; a++) {
            Thread.sleep(1000)
            activity.runOnUiThread(function () {
                button1.setText("2333" + a)
            })
        }
    }).start()

    context.abcd(context.getAaaa())

    var myInput = context.findViewById(R.id.myInput)
    var tv_label = context.findViewById(R.id.tv_label)
    myInput.setText("ddd")
    var watcher = new TextWatcher({
        afterTextChanged: function (editable) {
            tv_label.setText(editable)
        }
    })
    myInput.addTextChangedListener(watcher)

    var recyclerView = context.findViewById(R.id.recyclerView)
    recyclerView.setLayoutManager(new LinearLayoutManager(context))

    var adapterIntf = new RvAdapterIntf({
        onCreateViewHolder: function () {
            var view = new Button(context)
            return new RvAdapter.ViewHolder(view)
        },
        onBindViewHolder: function (holder, position) {
            holder.itemView.setText("" + position)
        },
        getItemCount: function () {
            return 100
        }
    })
    var adapter = new RvAdapter(adapterIntf)
    recyclerView.adapter = adapter

    var ee = new DDD.EEE({ hehe: function () { Log.i("23333", "yoooooooooooooooo") } })
    ee.hehe()

}


function onResume() {
    Toast.makeText(context, "onResume", Toast.LENGTH_SHORT).show()
}