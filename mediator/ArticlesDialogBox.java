package com.learning.mediator;

public class ArticlesDialogBox extends DialogBox{

    private ListBox articles_list_box = new ListBox(this);
    private TextBox title_text_box = new TextBox(this);
    private Button save_button = new Button(this);

    public void simulate_user_interaction(){
        articles_list_box.setSelection("article 1");
        System.out.println("text box: " + title_text_box.getContent());
        System.out.println("button: " + save_button.isEnabled());
        title_text_box.setContent("");
        System.out.println("text box: " + title_text_box.getContent());
        System.out.println("button: " + save_button.isEnabled());
        articles_list_box.setSelection("article 2");
        System.out.println("text box: " + title_text_box.getContent());
        System.out.println("button: " + save_button.isEnabled());



    }

    @Override
    public void changed(UIControl control) {
        if(control== articles_list_box)
            article_selected();
        else if (control==title_text_box)
            title_changed();
    }

    private void title_changed(){
        var content = title_text_box.getContent();
        var is_empty=(content==null|| content.isEmpty());
        save_button.setEnabled(!is_empty);
    }
    private void article_selected(){
        title_text_box.setContent(articles_list_box.getSelection());
        save_button.setEnabled(true);
     }
}
