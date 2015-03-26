package ee.itcollege;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class FirstPage extends LayoutPage {
	private static final long serialVersionUID = 1L;
	
	private int number = 0;

	@SuppressWarnings("serial")
	public FirstPage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		
		add(new BookmarkablePageLink<Void>("second", SecondPage.class));
		
		add(new Label("number", new Model<Integer>() {
			@Override
			public Integer getObject() {
				// TODO Auto-generated method stub
				return number;
			}
		}));
		
		add(new Link<Void>("add") {

			@Override
			public void onClick() {
				number++;
				System.out.println(number);
			}
			
		}); 
		// TODO Add your page's components here

    }
}
