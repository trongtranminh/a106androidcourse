package niit.android;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class SMSFolderExampleActitvity extends ListActivity {
    private ListAdapter adapter; 
    private static final Uri SMS_INBOX = Uri.parse("content://sms/inbox"); 
 
    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle); 
        Cursor c = getContentResolver().query(SMS_INBOX, null, null, null, null); 
        startManagingCursor(c); 
        String a[] = c.getColumnNames();
        String[] columns = new String[] {"body"}; 
        int[] names = new int[] { R.id.row }; 
        adapter = new SimpleCursorAdapter(this, R.layout.sms_folder, c, columns, 
                names); 
 
        setListAdapter(adapter);
        
    } 
}