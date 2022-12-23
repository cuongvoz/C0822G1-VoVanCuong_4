package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return this.iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        this.iMusicRepository.save(music);
    }
}
