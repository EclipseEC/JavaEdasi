package ee.itcollege;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class FirstPage extends LayoutPage {
	private static final long serialVersionUID = 1L;

	public FirstPage(final PageParameters parameters) {

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		
		add(new BookmarkablePageLink<Void>("link", SecondPage.class));

		// TODO Add your page's components here

    }
}
