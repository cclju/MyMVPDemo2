package com.android.mvp2.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.mvp2.R;
import com.android.mvp2.data.bean.Repo;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RepoViewHolder> {

    private ArrayList<Repo> mRepos;

    @Inject
    public ListAdapter() {
        mRepos = new ArrayList<>();
    }

    public void setRepos(ArrayList<Repo> repos) {
        mRepos = repos;
        notifyItemInserted(mRepos.size() - 1);
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bindTo(mRepos.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_iv_repo_name)
        TextView mIvRepoName;
        @Bind(R.id.item_iv_repo_detail)
        TextView mIvRepoDetail;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTo(Repo repo) {
            mIvRepoName.setText(repo.name );
            mIvRepoDetail.setText(String.valueOf(repo.description + "(" + repo.language + ")"));
        }
    }
}