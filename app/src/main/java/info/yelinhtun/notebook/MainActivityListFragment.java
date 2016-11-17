package info.yelinhtun.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        notes = new ArrayList<Note>();
        notes.add(new Note("Note 1", "Note 1 message", Note.Category.PERSONAL));
        notes.add(new Note("Note 2", "Note 2 message", Note.Category.TECHNICAL));
        notes.add(new Note("Note 3", "Note 3 message", Note.Category.FINANCE));
        notes.add(new Note("Note 4", "Note 4 message", Note.Category.QUOTE));

        noteAdapter = new NoteAdapter(getActivity(), notes);
        setListAdapter(noteAdapter);

//        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
//        getListView().setDividerHeight(1);

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        launchNoteDetailActivity(position, MainActivity.FragmentToLaunch.VIEW);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // Give me the position of whatever note I long pressed on
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int rowPosition = info.position;

        // returns to us id of whatever menu item we selected
        switch (item.getItemId()) {
            case R.id.edit:
                launchNoteDetailActivity(rowPosition, MainActivity.FragmentToLaunch.EDIT);
                return true;
        }

        return super.onContextItemSelected(item);
    }

    private void launchNoteDetailActivity(int position, MainActivity.FragmentToLaunch ftl) {
        // grab the note information associated with whatever note item we clicked on
        Note note = (Note) getListAdapter().getItem(position);

        // create a new intent that launches our noteDetailActivity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        // pass along the information of the note we clicked on to our noteDetailActivity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getNoteId());

        switch(ftl) {
            case VIEW:
                intent.putExtra(MainActivity.NOTE_FRAGMENT_T0_LOAD_EXTRA, MainActivity.FragmentToLaunch.VIEW);break;
            case EDIT:
                intent.putExtra(MainActivity.NOTE_FRAGMENT_T0_LOAD_EXTRA, MainActivity.FragmentToLaunch.EDIT); break;
        }

        startActivity(intent);
    }
}
