package ee.itcollege;

import java.util.Arrays;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class FirstPage extends LayoutPage {
	private static final long serialVersionUID = 1L;
	private int number = 0;
	@SuppressWarnings("serial")
	private Label label = new Label("number", new Model<Integer>() {
		@Override
		public Integer getObject() {
			// TODO Auto-generated method stub
			return number;
		}
	});

	@SuppressWarnings("serial")
	public FirstPage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings()
				.getVersion()));

		add(new BookmarkablePageLink<Void>("second", SecondPage.class));

		label.setOutputMarkupId(true);
		add(label);

		add(new AjaxLink<Void>("add") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				number++;
				target.add(label);
			}

		});

		add(new ListView<String>("list", Arrays.asList("test", "kala", "mati")) {
			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new Label("name", item.getModelObject()));
			}
		});
		// TODO Add your page's components here

	}
}
