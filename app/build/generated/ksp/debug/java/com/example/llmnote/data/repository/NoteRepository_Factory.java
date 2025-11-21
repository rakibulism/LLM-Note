package com.example.llmnote.data.repository;

import com.example.llmnote.data.local.dao.NoteDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NoteRepository_Factory implements Factory<NoteRepository> {
  private final Provider<NoteDao> noteDaoProvider;

  public NoteRepository_Factory(Provider<NoteDao> noteDaoProvider) {
    this.noteDaoProvider = noteDaoProvider;
  }

  @Override
  public NoteRepository get() {
    return newInstance(noteDaoProvider.get());
  }

  public static NoteRepository_Factory create(Provider<NoteDao> noteDaoProvider) {
    return new NoteRepository_Factory(noteDaoProvider);
  }

  public static NoteRepository newInstance(NoteDao noteDao) {
    return new NoteRepository(noteDao);
  }
}
