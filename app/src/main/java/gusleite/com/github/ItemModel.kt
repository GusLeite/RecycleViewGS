package gusleite.com.github

data class ItemModel(val praia: String
    , val estado: String
    , val cidade: String
    , val onRemove: (ItemModel) -> Unit)