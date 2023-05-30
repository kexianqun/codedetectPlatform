import torch
from transformers import BertTokenizer,  BertForMaskedLM

def serialize_tensor(tensor):
    # 自定义序列化方法，将 Tensor 转换为字典
    tensor_data = {
        'data': tensor.tolist(),
        'shape': tensor.shape,
        'dtype': str(tensor.dtype)
    }
    return tensor_data
def get_sentence_embedding(sentece, pooler_type='avg_first_last'):
    device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
    tokenizer = BertTokenizer.from_pretrained("E:\Project\python\code\codedetect\models/solidity_tokenize")
    model = BertForMaskedLM.from_pretrained("E:\Project\python\code\codedetect\models\solidity_model")
    model.to(device)
    inputs = tokenizer(
        [sentece],
        padding=True,
        truncation=True,
        max_length=512,
        return_tensors="pt")
    inputs = {k: v.to(device) for k, v in inputs.items()}
    with torch.no_grad():
        outputs = model(**inputs, output_hidden_states=True)
        hidden_states = outputs.hidden_states
        attention_mask = inputs['attention_mask']
        last_hidden = outputs.hidden_states[-1]
        embeddings = []
        if pooler_type == "avg":
            embeddings = (
                    (last_hidden * attention_mask.unsqueeze(-1)).sum(1) / attention_mask.sum(-1).unsqueeze(-1))
        elif pooler_type == "avg_first_last":
            first_hidden = hidden_states[0]
            last_hidden = hidden_states[-1]
            pooled_result = ((first_hidden + last_hidden) / 2.0 * attention_mask.unsqueeze(-1)).sum(
                1) / attention_mask.sum(
                -1).unsqueeze(-1)
            embeddings = pooled_result
        elif pooler_type == "avg_top2":
            second_last_hidden = hidden_states[-2]
            last_hidden = hidden_states[-1]
            pooled_result = ((last_hidden + second_last_hidden) / 2.0 * attention_mask.unsqueeze(-1)).sum(
                1) / attention_mask.sum(-1).unsqueeze(-1)
            embeddings = pooled_result
        elif pooler_type == "cls":
            embeddings = last_hidden[:, 0]
        return serialize_tensor(embeddings)