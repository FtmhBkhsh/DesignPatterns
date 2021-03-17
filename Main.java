package com.learning;

import com.learning.adaptor.CaramelFilter;
import com.learning.adaptor.Image;
import com.learning.adaptor.ImageView;
import com.learning.adaptor.avaFilter.Caramel;
import com.learning.bridge.AdvancedRemoteControl;
import com.learning.bridge.RemoteControl;
import com.learning.bridge.SamsungTV;
import com.learning.bridge.SonyTV;
import com.learning.change_of_responsibility.*;
import com.learning.command.AddCostomerCommand;
import com.learning.command.CustomerService;
import com.learning.command.fx.Button;
import com.learning.composite.Group;
import com.learning.composite.Shape;
import com.learning.decorator.CloudStream;//decorator
import com.learning.decorator.CompressedCloudStream;//decorator
import com.learning.decorator.EncryptedCloudStream;//decorator
import com.learning.decorator.Stream;//decorator
import com.learning.facade.NotificationService;
import com.learning.flyweight.PointIconFactory;
import com.learning.flyweight.PointService;
import com.learning.iterator.BrowseHistory;
import com.learning.iterator.Iterator;
import com.learning.mediator.ArticlesDialogBox;
import com.learning.memento.Editor;//memento
import com.learning.memento.History;//memento
import com.learning.observer.Chart;
import com.learning.observer.DataSource;
import com.learning.observer.SpreadSheet;
import com.learning.proxy.EbookProxy;
import com.learning.proxy.Library;
import com.learning.proxy.LoggingEbookProxy;
import com.learning.proxy.RealEbook;
import com.learning.state.BrushTool;
import com.learning.state.Canvas;
import com.learning.state.EraserTool;
import com.learning.state.SelectionTool;
import com.learning.strategy.BlackAndWhiteFilter;
import com.learning.strategy.ImageStorage;
import com.learning.strategy.JpegCompressor;
import com.learning.strategy.PngComoressor;
import com.learning.template.TransferMoneyTask;
import com.learning.visitor.*;

public class Main {

    public static void main(String[] args) {

//      --------------------------------memento--------------------------------
        var editor = new Editor();
        var history = new History();

        editor.setContent("1");
        history.push(editor.createState());
        System.out.println(editor.getContent());

        editor.setContent("2");
        history.push(editor.createState());
        System.out.println(editor.getContent());

        editor.setContent("3");
        history.push(editor.createState());
        System.out.println(editor.getContent());

        editor.restoreState(history.pop());
        System.out.println(editor.getContent());

        editor.restoreState(history.pop());
        System.out.println(editor.getContent());

//  -------------------------------decorator-------------------------------
        storeCreditCard(new CloudStream());
        storeCreditCard(new EncryptedCloudStream(new CloudStream()));
        storeCreditCard(new CompressedCloudStream(new CloudStream()));
        storeCreditCard(new CompressedCloudStream(new EncryptedCloudStream(new CloudStream())));
        storeCreditCard(new EncryptedCloudStream(new CompressedCloudStream(new CloudStream())));
//  ---------------------------------state---------------------------------
        var canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouse_up();
        canvas.mouse_down();
        canvas.mouse_up();

        canvas.setCurrentTool(new BrushTool());
        canvas.mouse_up();
        canvas.mouse_down();
        canvas.mouse_up();

        canvas.setCurrentTool(new EraserTool());
        canvas.mouse_up();
        canvas.mouse_down();
        canvas.mouse_up();
        ;
//  -------------------------------iterator--------------------------------
        var browse_history = new BrowseHistory();
        browse_history.push("A");
        browse_history.push("B");
        browse_history.push("C");

        Iterator iterator=browse_history.create_iterator();
        while (iterator.hasNext() ){
            var url= iterator.current();
            System.out.println(url);
            iterator.next();
        }
//  -------------------------------strategy--------------------------------
        var image_storage= new ImageStorage();
        image_storage.store("name of file",new JpegCompressor(),new BlackAndWhiteFilter());
        image_storage.store("name of file",new PngComoressor(),new BlackAndWhiteFilter());
//  --------------------------Template-Method------------------------------
        var task = new TransferMoneyTask();
        task.execute();
//  --------------------------------Command--------------------------------
        var service= new CustomerService();
        var command= new AddCostomerCommand(service);
        var button = new Button(command);
        button.click();
//  -------------------------------observer--------------------------------
        var data_source= new DataSource();
        var sheet1= new SpreadSheet();
        var sheet2= new SpreadSheet();
        var chart1= new Chart();
        data_source.addObserver(sheet1);
        data_source.addObserver(sheet2);
        data_source.addObserver(chart1);
        data_source.setValue(3);
        data_source.setValue(7 );
//  -------------------------------mediator--------------------------------
        var dialog= new ArticlesDialogBox();
        dialog.simulate_user_interaction();
//  -------------------------------visitor---------------------------------
        var doc = new HtmlDocument();
        doc.add(new HeadingNode());
        doc.add(new AncherNode());
        doc.execute(new HighlightingOperation());
        doc.execute(new PlainTextOperation());
//  -----------------------chain-of-responsibility-------------------------
        //authenticate->log->compress
        var compress = new Compressor(null);
        var log = new Logger(compress);
        var authenticate= new Authenticator(log);
        var server= new WebServer(authenticate);
        server.handle( new HttpRequest("I am not admin","1234"));
        server.handle( new HttpRequest("admin","1234"));
//  -------------------------------composite--------------------------------
        //authenticate->log->compress
        var group1= new Group();
        group1.add(new Shape());//square
        group1.add(new Shape());//square
        var group2= new Group();
        group2.add(new Shape());//circle
        group2.add(new Shape());//circle
        var group= new Group();
        group.add(group1);//circle
        group.add(group2);//circle
        group.render();
        group.move();
//  --------------------------------adaptor--------------------------------
        var image_view= new ImageView(new Image());
        image_view.apply(new CaramelFilter(new Caramel()));
//  ---------------------------------facade--------------------------------
        var notification_service= new NotificationService();
        notification_service.send("hi","target");
//  ------------------------------flyweight--------------------------------
        var point_service= new PointService(new PointIconFactory());
        for (var point: point_service.get_points())
            point.draw();
//  --------------------------------bridge---------------------------------
        var remote_control= new RemoteControl(new SonyTV());
        remote_control.turn_on();
        remote_control.turn_off();
        var advanced_remote_control= new AdvancedRemoteControl(new SamsungTV());
        advanced_remote_control.turn_on();
        advanced_remote_control.set_channel(3);
        advanced_remote_control.turn_off();
//  ---------------------------------proxy---------------------------------
        var library= new Library();
        String[] file_names = {"a","b","c"};

        for (var file_name: file_names) {
            library.add(new EbookProxy(file_name));
        }

        library.open_ebook("a");

        for (var file_name: file_names)
            library.add(new LoggingEbookProxy(file_name));

        library.open_ebook("c");
    }
//  -------------------------------decorator-------------------------------
    public static void storeCreditCard(Stream stream){
        stream.write("1234-1234-1234-1234");
    }
// -----------------------------------------------------------------------
}
//  -------------------------memento----output-----------------------------
//  1
//  2
//  3
//  3
//  2
//  -----------------------------------------------------------------------
//  -----------------------decorator----output-----------------------------
//  writing... 1234-1234-1234-1234
//  writing... #$@^@#$%^&*%^&;
//  writing... 123
//  writing... #$@^@#$%^&*%^&;
//  writing... #$@
//  -----------------------------------------------------------------------
//  ---------------------------state----output-----------------------------
//  selection icon
//  draw a dashed rectangle
//  selection icon
//  brush icon
//  draw a line
//  brush icon
//  eraser icon
//  erase something
//  eraser icon
//  -----------------------------------------------------------------------
//  ------------------------iterator----output-----------------------------
//  A
//  B
//  C
//  -----------------------------------------------------------------------
//  ------------------------strategy----output-----------------------------
//  compressing using jpeg
//  applying Black and white filter
//  compressing using png
//  applying Black and white filter
//  -----------------------------------------------------------------------
//  ---------------------Template-Method----output-------------------------
//  Audit
//  Transfer money
//  -----------------------------------------------------------------------
//  ------------------------observer----output-----------------------------
//  spreadsheet got updated
//  spreadsheet got updated
//  chart got updated
//  -----------------------------------------------------------------------
//  ------------------------mediator----output-----------------------------
//  text boxt: article 1
//  button: true
//  text boxt:
//  button: false
//  text boxt: article 2
//  button: true
//  -----------------------------------------------------------------------
//  -------------------------visitor----output-----------------------------
//  heading was highlighted
//  anchor was highlighted
//  heading text
//  anchor text
//  -----------------------------------------------------------------------
//  -----------------chain-of-responsibility----output---------------------
//  Authentication
//  wrong username or password
//  Authentication
//  log
//  compress
//  -----------------------------------------------------------------------
//  -----------------------composite----output-----------------------------
//  render shape
//  render shape
//  render shape
//  render shape
//  move shape
//  move shape
//  move shape
//  move shape
//  -----------------------------------------------------------------------
//  ---------------------------adaptor----output---------------------------
//  Applying caramel filter
//  -----------------------------------------------------------------------
//  -------------------------facade----output------------------------------
//  Sending a message
//  -----------------------------------------------------------------------
//  ------------------------flyweight-----output---------------------------
//  CAFE at (1,2)
//  ------------------------------------------------------------------------
//  ----------------------------bridge----output----------------------------
//  Sony:turn on
//  Sony:turn off
//  Samsung:turn on
//  Samsung:set channel
//  Samsung:turn off
//  ------------------------------------------------------------------------
//  ----------------------------proxy----output----------------------------
//  loading the ebook a
//  showing the ebook a
//  loading the ebook c
//  logging
//  showing the ebook c

