package com.example.hanghaememo.service;

import com.example.hanghaememo.dto.MemoRequestDto;
import com.example.hanghaememo.entity.Memo;
import com.example.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    @Transactional
    public Memo createMemo(MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }
    @Transactional(readOnly = true)
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        long a = 100L;
        Memo memos = new Memo(requestDto);
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if(Objects.equals(memo.getPassword(), requestDto.getPassword())){
            memo.update(requestDto);
        }else{
            return a;
        }
        return memo.getId();
    }
    @Transactional
    public Long deleteMemo(Long id,MemoRequestDto requestDto){
        long a = 100L;

        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if (Objects.equals(memo.getPassword(), requestDto.getPassword())){
            memoRepository.deleteById(id);
            return memo.getId();
        }else {
            return a;
        }
    }

}
