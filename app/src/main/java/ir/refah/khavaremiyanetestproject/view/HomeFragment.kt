package ir.refah.khavaremiyanetestproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ir.refah.khavaremiyanetestproject.R
import ir.refah.khavaremiyanetestproject.data.adapter.BookAdapter
import ir.refah.khavaremiyanetestproject.databinding.FragmentHomeBinding
import ir.refah.khavaremiyanetestproject.model.Book
import ir.refah.khavaremiyanetestproject.viewmodel.BookViewModel


class HomeFragment : Fragment() ,(Book) -> Unit{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        val application = requireNotNull(this.activity).application

        var mViewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(BookViewModel::class.java)


        binding.bookViewModel = mViewModel
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BookAdapter(mViewModel.mlist.value?.results?.books,this)

        mViewModel.fetchBooksFromServer(requireContext()).observe(viewLifecycleOwner, Observer {
            adapter.setData(it?.results?.books)
        })

        mViewModel.mShowProgressBar.observe(viewLifecycleOwner, Observer { bt ->
            if (bt) {
                binding.progressBar.visibility = View.VISIBLE
                binding.floatingActionButton.hide()
            } else {
                binding.progressBar.visibility = View.GONE
                binding.floatingActionButton.show()
            }
        })

        binding.recyclerView.adapter = adapter
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
            }
    }

    override fun invoke(book: Book) {
        val items = arrayOf(book.age_group
            ,book.amazon_product_url
            ,book.author
            ,book.contributor
            ,book.description
            ,book.primary_isbn10
            ,book.contributor_note
            ,book.book_review_link)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(book.title)
            .setItems(items) { dialog, which ->
            }
            .setNegativeButton(getString(R.string.close)){dialog,which->

            }
            .show()
    }
}