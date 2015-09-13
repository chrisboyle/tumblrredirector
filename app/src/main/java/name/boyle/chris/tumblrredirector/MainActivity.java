package name.boyle.chris.tumblrredirector;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Uri uri = getIntent().getData();
		if (uri == null || uri.getPathSegments().size() < 2 || !"post".equals(uri.getPathSegments().get(0))) {
			Toast.makeText(this, getString(R.string.no_url), Toast.LENGTH_SHORT).show();
		} else {
			final String user = uri.getHost().substring(0, uri.getHost().indexOf('.'));
			final String postId = uri.getPathSegments().get(1);
			Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(getString(R.string.tumblr_app_uri), user, postId)));
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
		}
		finish();
	}
}
